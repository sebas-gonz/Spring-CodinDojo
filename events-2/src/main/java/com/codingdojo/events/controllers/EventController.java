package com.codingdojo.events.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.events.models.Comment;
import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.CommentService;
import com.codingdojo.events.services.EventService;
import com.codingdojo.events.services.UserService;
import com.codingdojo.events.components.EstadosdeUsa;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EventController {

	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Autowired
	private EventService eventService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private EstadosdeUsa estados;


	@GetMapping("/events")
	public String eventos(Model model, HttpSession session, @ModelAttribute("event") Event event,BindingResult result) {
		setUserId((Integer) session.getAttribute("userId"));

		List<Event> eventosDelEstado = eventService.eventByState(userService.findUserById(getUserId()).getState());

		List<Event> eventos = eventService.eventNotInState(userService.findUserById(getUserId()).getState());

		model.addAttribute("stateEvents", eventosDelEstado);

		model.addAttribute("events", eventos);

		model.addAttribute("user", userService.findUserById(getUserId()));

		model.addAttribute("states", estados.getEstados());

		return "views/events.jsp";

	}

	@PostMapping("/events")
	public String crearEvento(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model,
			HttpSession session) {
		session.setAttribute("userId", getUserId());
		List<Event> eventosDelEstado = eventService.eventByState(userService.findUserById(getUserId()).getState());

		List<Event> eventos = eventService.eventNotInState(userService.findUserById(getUserId()).getState());
		if (result.hasErrors()) {
			model.addAttribute("stateEvents", eventosDelEstado);

			model.addAttribute("events", eventos);

			model.addAttribute("user", userService.findUserById(userId));

			model.addAttribute("states", estados.getEstados());

			return "views/events.jsp";
		}
		event.setUser(userService.findUserById(getUserId()));
		eventService.createEvent(event);
		userService.findUserById(getUserId()).getEvents().add(event);
		return "redirect:/events";

	}

	@GetMapping("/events/{eventid}/edit")
	public String editarEvento(@PathVariable("eventid") Long id, Model model, @ModelAttribute("event") Event event,BindingResult result) {
		model.addAttribute("event", eventService.eventById(id));

		model.addAttribute("states", estados.getEstados());

		return "views/editevent.jsp";

	}

	@PostMapping("/events/{eventid}/edit")
	public String editarEvento(@Valid @ModelAttribute("event") Event event, BindingResult result,@PathVariable("eventid") Long id) {
		if (result.hasErrors()) {
			return "views/editevent.jsp";
		}
		eventService.editarEvento(id, event);

		return "redirect:/events";
	}

	@GetMapping("/events/{id}")
	public String mostrarEvento(@PathVariable("id") Long id, Model model,@ModelAttribute("comment") Comment comment,BindingResult result,HttpSession session) {
		session.setAttribute("userId", getUserId());
		model.addAttribute("event", eventService.eventById(id));
		model.addAttribute("userInEvent", eventService.eventById(id).getUsers());
		model.addAttribute("comments", eventService.eventById(id).getComments());

		return "views/evento.jsp";
	}

	@PostMapping("/events/{commentEventId}/comment")
	public String comentarEvento(@PathVariable("commentEventId") Long id, @Valid @ModelAttribute("comment") Comment comment,BindingResult result,
			Model model,HttpSession session) {
		session.setAttribute("userId", getUserId());
		if (result.hasErrors()) {
			model.addAttribute("event", eventService.eventById(id));
			model.addAttribute("userInEvent", eventService.eventById(id).getUsers());
			model.addAttribute("comments", eventService.eventById(id).getComments());
			return "views/evento.jsp";
		}
		
		comment.setEvent(eventService.eventById(id));
		comment.setUser(userService.findUserById(getUserId()));
		
		commentService.createComment(comment);
		
		return "redirect:/events/" + id;
	}

	@GetMapping("/logout")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/events/{deleteEventId}/delete")
	public String eliminarEvento(@PathVariable("deleteEventId") Long id, HttpSession session, @ModelAttribute("event") Event event) {
		session.setAttribute("userId", getUserId());
		eventService.eliminarEvento(id);
		return "redirect:/events";
	}

	@PostMapping("events/{joinEventId}/join")
	public String unirseAlEvento(@PathVariable("joinEventId") Long id, HttpSession session, @ModelAttribute("event") Event event) {
		session.setAttribute("userId", getUserId());
		Event evento = eventService.eventById(id);
		User user = userService.findUserById(getUserId());

		evento.getUsers().add(user);
		eventService.createEvent(evento);
		return "redirect:/events";
	}

	@PostMapping("events/{cancelEventId}/cancel")
	public String cancelarEvento(@PathVariable("cancelEventId") Long id, HttpSession session, @ModelAttribute("event") Event event) {
		session.setAttribute("userId", getUserId());
		Event cancelarEvent = eventService.eventById(id);
		User user = userService.findUserById(getUserId());

		cancelarEvent.getUsers().remove(user);
		eventService.createEvent(cancelarEvent);
		return "redirect:/events";
	}
}
