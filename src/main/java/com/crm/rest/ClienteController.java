package com.crm.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crm.entity.Cliente;
import com.crm.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(value="api")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	//Endpoint para "/clientes" - GET -  retorna lista de clientes
	@ApiOperation(value="Retonar lista de clientes")
	@GetMapping("/clientes")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Cliente> getClientes() {
		return clienteService.getClientes();
	}
	
	//Endpoint para "/clientes/{idCliente}" - GET -  retorna un cliente por id
	@ApiOperation(value="Retonar cliente por id")
	@GetMapping("/clientes/{idCliente}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Cliente getClientePorId(@PathVariable int idCliente) {
		Cliente cliente = clienteService.getCliente(idCliente);
		if(cliente == null) {
			throw new ClienteNotFoundException("Id no encontrado - " + idCliente);
		}
		return cliente ;
	}
	
	//Endpoint para "/clientes" - POST -  crea un cliente
	@ApiOperation(value="Crear cliente")
	@PostMapping("/clientes")
	@CrossOrigin(origins = "http://localhost:3000")
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		//Tambien en caso de que pases un id en JSON.. setea el id a 0
		//esto fuerza a que se aplique el save .. en vez de un update
		cliente.setIdCliente(0);
		return clienteService.saveOrUpdateCliente(cliente);
	}
	
	//Endpoint para "/clientes" - PUT -  actualiza un cliente
	@ApiOperation(value="Actualizar datos clientes")
	@PutMapping("/clientes")
	@CrossOrigin(origins = "http://localhost:3000")
	public Cliente actualizarCliente(@RequestBody Cliente cliente) { 
		return clienteService.saveOrUpdateCliente(cliente);
	}
	
	//Endpoint para "/clientes/{idCliente}" - DELETE -  elimina un cliente por id
	@ApiOperation(value="Borrar cliente por id")
	@DeleteMapping("/clientes/{idCliente}")
	@CrossOrigin(origins = "http://localhost:3000")
	public String borrarCliente(@PathVariable int idCliente) { 
		clienteService.deleteCliente(idCliente);
		return "Cliente borrado de la base de datos - " + idCliente;
	}
	
	
}
