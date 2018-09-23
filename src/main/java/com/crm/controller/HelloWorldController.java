package com.crm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.model.Cliente;

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
	
	@GetMapping("/processFormInstanciarCliente")
	public String processFormInstanciarCliente(Model model) {
		/*Agregamos un objeto Cliente vacio al Model para que cuando se haga el
		forward al jsp ahi en el jsp le llene a dicho objeto Cliente los valores
		que el usuario ingrese en el formulario*/
		model.addAttribute("cliente", new Cliente());
		
		return "helloworld-form";
	}
	
	@PostMapping("/processFormInstanciarClienteUpperCase")
	public String processFormInstanciarClienteUpperCase(@ModelAttribute("cliente")Cliente cliente) {

		String primerNombre = cliente.getprimerNombre();
		primerNombre = primerNombre.toUpperCase();
		System.out.print("LOG: Dentro del metodo processFormInstanciarClienteUpperCase " + primerNombre);
		return "helloworld";
	}

}
