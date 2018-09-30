package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crm.entity.Cliente;
import com.crm.service.ClienteService;


@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/crear")
	public String crearCliente(Model model) {	
		clienteService.setCliente(new Cliente("Pancracio"));
		return "lista-clientes";
	}
	
	//Endpoint obtener lista clientes
	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
		return clienteService.getClientes();
	}

}
