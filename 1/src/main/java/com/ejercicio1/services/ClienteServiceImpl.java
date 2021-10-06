package com.ejercicio1.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.ejercicio1.persistence.Cliente;
import com.ejercicio1.persistence.ClienteDao;

import com.ejercicio1.persistence.Cliente;

public class ClienteServiceImpl implements ClienteServiceI {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional
	public void insertNewCliente(final Cliente newCliente) {

		if (newCliente != null && newCliente.getClienteId() == null) {
			clienteDao.insert(newCliente);
		}

	}

	@Override
	@Transactional
	public void updateNewCliente(final Cliente updateCliente) {

		if (updateCliente != null && updateCliente.getClienteId() != null) {
			clienteDao.update(updateCliente);
		}

	}

	@Override
	@Transactional
	public void deleteCliente(final Cliente deleteCliente) {

		if (deleteCliente != null && deleteCliente.getClienteId() != null) {
			clienteDao.delete(deleteCliente);
		}

	}

	@Override
	@Transactional
	public Cliente searchById(final Long clienteId) {

		Cliente cliente = null;
		
		if (clienteId != null) {

			cliente = clienteDao.searchById(clienteId);
		}
		return cliente;
	}

	@Override
	@Transactional
	public List<Cliente> searchByCliente(final String nombre, final String apellido1, final String apellido2) {

		List<Cliente> clienteList = new ArrayList<Cliente>();
		
		if (StringUtils.hasText(nombre) && StringUtils.hasText(apellido1) && StringUtils.hasText(apellido2)) {

			clienteList = clienteDao.searchByCliente(nombre, apellido1, apellido2);
		}

		return clienteList;
	}

	@Override
	@Transactional
	public List<Cliente> searchAll() {

		List<Cliente> clienteList = new ArrayList<Cliente>();

		clienteList = clienteDao.searchAll();

		return clienteList;
	}	
}
