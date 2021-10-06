package com.ejercicio1.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contrato")
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Id del contrato
	 */
	private Long contratoId;
	
	/**
	 * Inicio Contrato
	 */
	private Date inicioContrato;
	
	/**
	 * Termino Contrato
	 */
	private Date terminoContrato;
	
	/**
	 * Precio Contrato
	 */
	private Double precio;
	
	/**
	 * Relacion con el cliente
	 */
	private Cliente asociacion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getContratoId() {
		return contratoId;
	}

	public void setContratoId(Long contratoId) {
		this.contratoId = contratoId;
	}
	
	@Column(name = "InicioContrato", nullable = false)
	public Date getInicioContrato() {
		return inicioContrato;
	}

	public void setInicioContrato(Date inicioContrato) {
		this.inicioContrato = inicioContrato;
	}

	@Column(name = "TerminoContrato", nullable = true)
	public Date getTerminoContrato() {
		return terminoContrato;
	}

	public void setTerminoContrato(Date terminoContrato) {
		this.terminoContrato = terminoContrato;
	}

	@Column(name = "Precio", nullable = true)
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@ManyToOne
	@JoinColumn(name = "clienteId")
	public Cliente getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Cliente asociacion) {
		this.asociacion = asociacion;
	}

	@Override
	public String toString() {
		return "Contrato [contratoId=" + contratoId + ", inicioContrato=" + inicioContrato + ", terminoContrato="
				+ terminoContrato + ", precio=" + precio + ", asociacion=" + asociacion + "]";
	}
	
	
}
