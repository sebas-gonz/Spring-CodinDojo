package com.codingdojo.elcodigo.elcodigocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodigoController {
	
	@RequestMapping("/")
	public String pedirCodigo() {
		return "codigo.jsp";
		
	}
	
	@RequestMapping(value="/codigo", method=RequestMethod.POST )
	public String comprobarCodigo(@RequestParam(value = "password") String password) {
		String codigo = "bushido";
		if(codigo.equals(password)) {
			
			return "secret.jsp";
		}
		else {
			return "redirect:/error-codigo";
		}
	}
	@RequestMapping("/error-codigo")
	public String errorCodigo(RedirectAttributes error) {
		error.addFlashAttribute("error", "¡Debes intentarlo más!");
		
		return "redirect:/";
	}

}
