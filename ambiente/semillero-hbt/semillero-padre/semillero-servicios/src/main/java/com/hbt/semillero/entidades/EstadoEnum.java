package com.hbt.semillero.entidades;

/**
 * Respresenta el estado Activo e Inactivo.
 * 
 * @author Angye Daniela Torres
 *
 */
public enum EstadoEnum {

	ACTIVO("enum.estado.activo"), INACTIVO("enum.estado.inactivo");

	/**
	 * Valor de cada enumerado.
	 */
	private String codigoEstado;

	/**
	 * Constructor unico.
	 * 
	 * @param codigoEstado
	 */
	private EstadoEnum(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	/**
	 * Obtener el codigo del estado.
	 * 
	 * @return
	 */
	public String getCodigoEstado() {
		return codigoEstado;
	}

	/**
	 * Cambiar el codigo del estado.
	 * 
	 * @param codigoEstado
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
}
