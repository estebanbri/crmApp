package com.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@GetMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@GetMapping("/processFormUpperCase")
	public String processFormUpperCase(@RequestParam("clienteNameFieldForm") String name, Model model) {
	
		
		name = name.toUpperCase();
		
		model.addAttribute("mensajeAtributo", name);
		
		return "helloworld";
	}

}
