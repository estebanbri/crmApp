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

	public Cliente saveOrUpdateCliente(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cliente);
		return cliente;
	}

	public List<Cliente> getClientes() {
		Session session = sessionFactory.getCurrentSession();
		Query<Cliente> query = session.createQuery("from Cliente");
		List<Cliente> clientes = query.list();
		return clientes;
	}

	public Cliente getCliente(int idCliente) {
		Session session = sessionFactory.getCurrentSession();
		Cliente cliente = session.get(Cliente.class, idCliente);
		return cliente;
	}
	
	public void deleteCliente(int idCliente) {
		Session session = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query query = session.createQuery("delete from Cliente where idCliente=:idCliente");
		query.setParameter("idCliente", idCliente);
		query.executeUpdate();	;
	}

}
