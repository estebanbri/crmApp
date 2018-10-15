package com.crm.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public List<Cliente> getClientes() {
		return clienteService.getClientes();
	}
	
	//Endpoint para "/clientes/{idCliente}" - GET -  retorna un cliente por id
	@ApiOperation(value="Retonar cliente por id")
	@GetMapping("/clientes/{idCliente}")
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
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		//Tambien en caso de que pases un id en JSON.. setea el id a 0
		//esto fuerza a que se aplique el save .. en vez de un update
		cliente.setIdCliente(0);
		return clienteService.saveOrUpdateCliente(cliente);
	}
	
	//Endpoint para "/clientes" - PUT -  actualiza un cliente
	@ApiOperation(value="Actualizar datos clientes")
	@PutMapping("/clientes")
	public Cliente actualizarCliente(@RequestBody Cliente cliente) { 
		return clienteService.saveOrUpdateCliente(cliente);
	}
	
	//Endpoint para "/clientes/{idCliente}" - DELETE -  elimina un cliente por id
	@ApiOperation(value="Borrar cliente por id")
	@DeleteMapping("/clientes/{idCliente}")
	public String borrarCliente(@PathVariable int idCliente) { 
		clienteService.deleteCliente(idCliente);
		return "Cliente borrado de la base de datos - " + idCliente;
	}
	
	
}
