package com.codingdojo.enrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	
	@RequestMapping("")
	public String helloCoding() {
		return "¡Hola Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String helloPython() {
		return "¡Python/Django fue increíble!";
	}
	
	@RequestMapping("/java")
	public String helloJava() {
		return "¡Java/Spring es mejor!";
	}
}
