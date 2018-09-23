package com.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String processFormUpperCase(HttpServletRequest request, Model model) {
		
		String mensajeObj = request.getParameter("clienteNameFieldForm");
		
		mensajeObj = mensajeObj.toUpperCase();
		
		model.addAttribute("mensajeAtributo", mensajeObj);
		
		return "helloworld";
	}

}
