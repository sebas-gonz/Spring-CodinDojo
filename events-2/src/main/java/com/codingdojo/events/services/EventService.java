package com.codingdojo.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepo;
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public Event eventById(Long id) {
		Optional<Event> event = eventRepo.findById(id);
		if(event.isPresent()) {
			return event.get();
		} else {
			return null;
		}	
	}
	
	public List<Event> eventByState(String state) {
		List<Event> events = eventRepo.findByState(state);
		return events;
	}
	
	public List<Event> eventNotInState(String state){
		List<Event> events = eventRepo.findByStateNot(state);
		return events;
	}
	public void eliminarEvento(Long id) {
		if(eventRepo.existsById(id)) {
			eventRepo.deleteById(id);
		}
	}
	public Event editarEvento(Long id, Event event) {
		 Optional<Event> evento = eventRepo.findById(id);
		    
		    if (evento.isPresent()) {
		        Event editarEvento = evento.get();
		        
		        editarEvento.setName(event.getName());
		        editarEvento.setDate(event.getDate());
		        editarEvento.setLocation(event.getLocation());
		        editarEvento.setState(event.getState());
		        
		        return eventRepo.save(editarEvento);
		    } else {
		        return null;
		    }
	}
}
