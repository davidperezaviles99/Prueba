package com.ejercicio1.persistence;

import java.util.List;

public abstract class ContratoDao extends Contrato {
	
	public abstract void insert(Contrato newContrato);
	
	public abstract void update(Contrato updateContrato);
	
	public abstract void delete(Contrato deleteContrato);
	
	public abstract List<Contrato> searchByCliente(final Cliente cliente);
	
}
