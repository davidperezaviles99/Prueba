package com.ejercicio1.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador del Id del Cliente
	 */
	private Long clienteId;

	/**
	 * Nombre del cliente
	 */
	private String nombre;

	/**
	 * Apellido1 del cliente
	 */
	private String apellido1;

	/**
	 * Apellido2 del cliente
	 */
	private String apellido2;

	/**
	 * Dni del cliente
	 */
	private String clienteDNI;
	
	/**
	 * Relacion con los contratos
	 */
	private List<Contrato> ListaContrato;

	/**
	 * @return ClienteId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getClienteId() {
		return clienteId;
	}

	/**
	 * 
	 * @param clienteId
	 */
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * 
	 * @return el nombre
	 */
	@Column(name = "Nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return apellido1
	 */
	@Column(name = "Apellido1", nullable = false)
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * 
	 * @param apellido1
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * 
	 * @return apellido2
	 */
	@Column(name = "Apellido2", nullable = false)
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * 
	 * @param apellido2
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * 
	 * @return ClienteDNI
	 */
	@Column(name = "DNI_Cliente", nullable = false, length = 9, unique = true)
	public String getClienteDNI() {
		return clienteDNI;
	}

	/**
	 * 
	 * @param clienteDNI
	 */
	public void setClienteDNI(String clienteDNI) {
		this.clienteDNI = clienteDNI;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "asociacion")
	public List<Contrato> getListaContrato() {
		return ListaContrato;
	}

	public void setListaContrato(List<Contrato> listaContrato) {
		ListaContrato = listaContrato;
	}

	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", clienteDNI=" + clienteDNI + "]";
	}
	
	

}
