package com.crm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crm.entity.Cliente;
import com.crm.entity.ClienteErrorResponse;
import com.crm.entity.ClienteNotFoundException;
import com.crm.service.ClienteService;


@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/crear")
	public String crearCliente(Model model) {
		Cliente cliente = crearCliente("Jose");
		clienteService.setCliente(cliente);
		return "crear-cliente";
	}
	
	//Endpoint para "/clientes" - retorna lista de clientes
	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
		return clienteService.getClientes();
	}
	
	//Endpoint para "/clientes/{idCliente}" - retorna cliente por id
	@GetMapping("/clientes/{idCliente}")
	public Cliente getClientePorId(@PathVariable int idCliente) {
		Cliente cliente = clienteService.getCliente(idCliente);
		if(cliente == null) {
			throw new ClienteNotFoundException("Id no encontrado - " + idCliente);
		}
		return cliente ;
	}
	
	public static Cliente crearCliente(String primerNombre) {
		return Cliente.builder()
				.primerNombre(primerNombre)
				.build();
	}
	
}
