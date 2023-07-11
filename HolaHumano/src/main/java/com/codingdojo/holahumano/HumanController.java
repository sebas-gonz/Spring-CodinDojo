package com.codingdojo.holahumano;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	
	@RequestMapping("/")
	public String saludar(@RequestParam(value="q", required = false) String searchQuery,@RequestParam(value="b", required = false) String searchQuery2) {
		
		if(searchQuery == null && searchQuery2 == null) {
			return "<h1>Hello Human</h1><br> <p> Welcome to SpringBoot</p>";
		}
		
		else if(searchQuery2 == null) {
			return "<h1>Hello "+searchQuery+"</h1><br> <p>  Welcome to SpringBoot </p>";
		}
		return "<h1>Hello "+searchQuery+" "+searchQuery2+"</h1><br> <p>  Welcome to SpringBoot </p>";
		
		
	}

}
