package com.ejercicio1.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio1.services.ContratoServiceI;


@Repository
public abstract class ContratoDaoImpl {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Contrato> searchByCliente(final Cliente Cliente) {

		Session currentSession = entityManager.unwrap(Session.class);

		final List<Contrato> ListaContrato = currentSession.createQuery("FROM Contrato WHERE asociacion.clienteId=" + Cliente.getClienteId()).list();
		currentSession.close();

		return ListaContrato;
	}

}
