package com.crm.repository;

import java.util.List;

import com.crm.entity.Cliente;

public interface ClienteDao {
	
	public Cliente saveOrUpdateCliente(Cliente cliente);

	public List<Cliente> getClientes();
	
	public Cliente getCliente(int idCliente);
}
