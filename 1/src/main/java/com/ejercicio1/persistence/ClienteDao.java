package com.ejercicio1.persistence;

import java.util.List;

public interface ClienteDao {
	
	/**
	 * Inserta un cliente en la BBDD
	 * @param newCliente
	 */
	public void insert(Cliente newCliente);
	
	/**
	 * Actualiza el cliente en la BBDD
	 * @param updateCliente
	 */
	public void update (Cliente updateCliente);
	
	/**
	 * Elimina el cliente en la BBDD
	 * @param deleteCliente
	 */
	public void delete (Cliente deleteCliente);
	
	/**
	 * Busqueda de un cliente segun su ID
	 * @param clienteId
	 * @return Cliente
	 */
	public Cliente searchById ( final Long clienteId);
	
	/**
	 * Busqueda de los clientes en la BBDD
	 * @return List<Cliente>
	 */
	public List<Cliente> searchAll();
	
	/**
	 * Obtiene el cliente por su nombre y apellidos
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @return List<Cliente>
	 */
	public List<Cliente> searchByCliente ( final String nombre, final String apellido1, final String apellido2);
	
	
	

}
