package com.ejercicio1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejercicio1.persistence.Cliente;
import com.ejercicio1.persistence.Contrato;
import com.ejercicio1.persistence.ContratoDao;

public class ContratoServiceImpl implements ContratoServiceI {

	@Autowired
	private ContratoDao contratoDao;
	
	@Override
	public void insertNewContrato(Contrato newContrato) {
		if (newContrato != null && newContrato.getContratoId() == null) {
			contratoDao.insert(newContrato);
		}
	}

	@Override
	public void updateNewContrato(Contrato updateContrato) {
		if (updateContrato != null && updateContrato.getContratoId() != null) {

			contratoDao.update(updateContrato);
		}		
	}

	@Override
	public void deleteContrato(Contrato deleteContrato) {
		if (deleteContrato != null && deleteContrato.getContratoId() != null) {

			contratoDao.delete(deleteContrato);
		}
		
	}

	@Override
	public List<Contrato> searchAll() {
		return null;
	 //Falta por Completar
	}

	@Override
	public List<Contrato> searchById(long contratoId) {
		return null;
		 //Falta por Completar
	}

	@Override
	public List<Contrato> buscarCliente(Cliente cliente) {
		List<Contrato> listaContrato = new ArrayList<Contrato>();

		if (cliente != null) {
					listaContrato = contratoDao.searchByCliente(cliente);
		}
		return listaContrato;
	}

	
}
