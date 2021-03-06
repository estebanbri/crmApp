package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Cliente;
import com.crm.repository.ClienteDao;

@Service
public class ClienteService {
	
	@Autowired
	ClienteDao clienteDao;
	
	@Transactional
	public Cliente saveOrUpdateCliente(Cliente cliente) {
		return clienteDao.saveOrUpdateCliente(cliente);
	}
	
	@Transactional
	public List<Cliente> getClientes() {
		return clienteDao.getClientes();
	}
	
	@Transactional
	public Cliente getCliente(int idCliente) {
		return clienteDao.getCliente(idCliente);
	}
	
	@Transactional
	public void deleteCliente(int idCliente) {
		clienteDao.deleteCliente(idCliente);
	}

}
