package com.crm.repository;

import java.util.List;

import com.crm.entity.Cliente;

public interface ClienteDao {
	
	public void setCliente(Cliente cliente);

	public List<Cliente> getClientes();
}
