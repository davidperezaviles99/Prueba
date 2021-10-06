package com.ejercicio1.persistence;

import org.springframework.stereotype.Repository;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio1.persistence.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insert(Cliente newCliente) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.save(newCliente);

		currentSession.close();

	}

	@Override
	@Transactional
	public void update(final Cliente updateCliente) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(updateCliente);

		currentSession.close();

	}

	@Override
	@Transactional
	public void delete(Cliente deleteCliente) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.delete(deleteCliente);

		currentSession.close();

	}

	@Override
	@Transactional
	public Cliente searchById(final Long clienteId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Cliente result = currentSession.get(Cliente.class, clienteId);

		currentSession.close();

		return result;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Cliente> searchAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		List<Cliente> list = currentSession.createQuery("FROM Cliente").list();

		currentSession.close();

		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByCliente(String nombre, String apellido1, String apellido2) {

		Session currentSession = entityManager.unwrap(Session.class);

		final List<Cliente> listaCliente = currentSession
		        .createQuery("FROM Cliente WHERE nombre='" + nombre + "' AND apellido1='" + apellido1 + "' AND apellido2='" + apellido2 + "'").list();

		return listaCliente;
	}

}
