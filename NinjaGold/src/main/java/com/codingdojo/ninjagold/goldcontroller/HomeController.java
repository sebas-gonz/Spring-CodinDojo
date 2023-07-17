package com.codingdojo.ninjagold.goldcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	private ArrayList<String> registro = new ArrayList<>();

	@RequestMapping("/")
	public String home(HttpSession session, Model model) {
		model.addAttribute("registro", registro);
		if (session.getAttribute("oro") == null) {
			session.setAttribute("oro", 0);
		}

		return "home.jsp";
	}

	@RequestMapping(value = "/granja", method = RequestMethod.POST)
	public String granja(HttpSession session) {

		Random numero = new Random();

		DateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy HH:mm aa");

		String fecha = dateFormat.format(new Date());

		int oro = numero.nextInt(20 - 10 + 1) + 10;
		int oroTotal = (int) session.getAttribute("oro");

		String oroGenerado = "Haz entrado a la granja y obtenido " + oro + " de oro " + "(" + fecha + ")";

		registro.add(oroGenerado);

		oroTotal = oroTotal + oro;
		session.setAttribute("oro", oroTotal);

		return "redirect:/";
	}

	@RequestMapping(value = "/cueva", method = RequestMethod.POST)
	public String cueva(HttpSession session) {

		Random numero = new Random();

		DateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy HH:mm aa");

		String fecha = dateFormat.format(new Date());

		int oro = numero.nextInt(10 - 5 + 1) + 5;
		int oroTotal = (int) session.getAttribute("oro");

		String oroGenerado = "Haz entrado a la cueva y haz obtenido " + oro + " de oro " + "(" + fecha + ")";

		registro.add(oroGenerado);

		oroTotal = oroTotal + oro;
		session.setAttribute("oro", oroTotal);

		return "redirect:/";
	}

	@RequestMapping(value = "/casa", method = RequestMethod.POST)
	public String casa(HttpSession session, Model model) {

		Random numero = new Random();
		
		DateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy HH:mm aa");

		String fecha = dateFormat.format(new Date());

		int oro = numero.nextInt(5 - 2 + 1) + 2;
		int oroTotal = (int) session.getAttribute("oro");

		oroTotal = oroTotal + oro;
		session.setAttribute("oro", oroTotal);

		String oroGenerado = "Haz entrado a la casa y obtenido " + oro + " de oro " + "(" + fecha + ")";

		registro.add(oroGenerado);

		session.setAttribute("registro", oroGenerado);

		return "redirect:/";
	}

	@RequestMapping(value = "/casino", method = RequestMethod.POST)
	public String casino(HttpSession session) {

		Random numero = new Random();
		
		DateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy HH:mm aa");

		String fecha = dateFormat.format(new Date());
		
		int moneda = numero.nextInt(2) + 1;
		int oro = numero.nextInt(50) + 1;
		int oroTotal = (int) session.getAttribute("oro");

		if (moneda == 1) {
			oroTotal = oroTotal + oro;
			session.setAttribute("oro", oroTotal);

			String oroGenerado = "Haz entrado al casino y obtenido " + oro + " de oro " + "(" + fecha + ")";

			registro.add(oroGenerado);

			return "redirect:/";
		}
		else {	
			oroTotal = oroTotal - oro;
			session.setAttribute("oro", oroTotal);
			
			if(oroTotal <= -200){
				return "jail.jsp";
			}

			String oroPerdido = "Haz entrado al casino y perdido " + oro + " de oro " + "(" + fecha + ")";

			registro.add(oroPerdido);

			return "redirect:/";
		}
	}


	@RequestMapping(value = "/spa", method = RequestMethod.POST)
	public String spa(HttpSession session) {
		Random numero = new Random();
		
		DateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy HH:mm aa");

		String fecha = dateFormat.format(new Date());

		int oro = numero.nextInt(20 - 5 + 1) + 5;
		int oroTotal = (int) session.getAttribute("oro");
		oroTotal = oroTotal - oro;

		String oroPerdido = "Haz entrado al spa y perdido " + oro + " de oro " + "(" + fecha + ")";

		registro.add(oroPerdido);

		session.setAttribute("oro", oroTotal);
		if (oroTotal < -200) {
			return "jail.jsp";
		} else {

			return "redirect:/";
		}
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String reset(HttpSession session,Model model) {
		session.invalidate();
		registro.clear();
		return "redirect:/";
	}

}
