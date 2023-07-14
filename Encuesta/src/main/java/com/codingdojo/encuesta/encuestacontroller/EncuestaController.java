package com.codingdojo.encuesta.encuestacontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EncuestaController {
	
	@RequestMapping("/")
	public String encuesta() {
		return "encuesta.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String resultado(Model model,@RequestParam(value="nombre") String nombre,@RequestParam(value="dojos") String dojos,@RequestParam(value="lenguaje") String lenguaje,@RequestParam(value="comentarios", required=false) String descripcion) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("dojos", dojos);
		model.addAttribute("lenguaje", lenguaje);
		model.addAttribute("descripcion", descripcion);
		
		return "resultado.jsp";
	}
}
