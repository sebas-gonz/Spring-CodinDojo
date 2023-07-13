package com.codingdojo.mostrarfecha.HomeController;

import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class HomeController {
	@RequestMapping("/")
    public String welcome() {
        return "welcome.jsp";
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
    	DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
    	String fecha = dateFormat.format(new Date());
    	model.addAttribute("fecha", fecha);
        return "date.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model) {
    	DateFormat dateFormat = new SimpleDateFormat("HH:mm aa");
    	
    	String hora = dateFormat.format(new Date()).toString();
    	model.addAttribute("hora", hora);
    	
    	return "time.jsp";
    }
}
