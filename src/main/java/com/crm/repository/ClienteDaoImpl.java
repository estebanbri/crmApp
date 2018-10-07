package com.crm.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.entity.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {
	
	Logger log = LoggerFactory.getLogger(ClienteDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public Cliente saveOrUpdateCliente(Cliente cliente) {
		log.debug("Inici� la creacion/actualizacion del cliente con nombre =  {} ... ",cliente.getPrimerNombre());
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cliente);
		log.debug("Finaliz� la creacion/actualizacion del cliente con nombre =  {} ... ",cliente.getPrimerNombre());
		return cliente;
	}

	public List<Cliente> getClientes() {
		log.debug("Inici� la obtenci�n de clientes");
		Session session = sessionFactory.getCurrentSession();
		Query<Cliente> query = session.createQuery("from Cliente");
		List<Cliente> clientes = query.list();
		log.debug("Finaliz� la la obtenci�n de clientes");
		return clientes;
	}

	public Cliente getCliente(int idCliente) {
		log.debug("Inici� la obtenci�n de cliente con id = {}  ... ", idCliente);
		Session session = sessionFactory.getCurrentSession();
		Cliente cliente = session.get(Cliente.class, idCliente);
		log.debug("Finaliz� la obtenci�n de cliente con id = {}  ... ", idCliente);
		return cliente;
	}
	
	public void deleteCliente(int idCliente) {
		log.debug("Inici� el borrado del cliente con id =  {} ... ", idCliente);
		Session session = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query query = session.createQuery("delete from Cliente where idCliente=:idCliente");
		query.setParameter("idCliente", idCliente);
		query.executeUpdate();	;
		log.debug("Finaliz� el borrado del cliente con id =  {} ... ", idCliente);
	}

}
