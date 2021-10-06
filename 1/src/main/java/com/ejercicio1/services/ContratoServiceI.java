package com.ejercicio1.services;

import java.util.List;

import com.ejercicio1.persistence.Cliente;
import com.ejercicio1.persistence.Contrato;

public interface ContratoServiceI {

	public void insertNewContrato(final Contrato newContrato);
	
	public void updateNewContrato(final Contrato updateContrato);
	
	public void deleteContrato(final Contrato deleteContrato);
	
	public List<Contrato> searchAll();
	
	public List<Contrato> searchById(final long contratoId);
	
	public List<Contrato> buscarCliente(final Cliente cliente);
}
