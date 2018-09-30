package com.crm.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.entity.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setCliente(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cliente);
	}

	public List<Cliente> getClientes() {
		Session session = sessionFactory.getCurrentSession();
		Query<Cliente> query = session.createQuery("from Cliente");
		List<Cliente> clientes = query.list();
		return clientes;
	}

}
