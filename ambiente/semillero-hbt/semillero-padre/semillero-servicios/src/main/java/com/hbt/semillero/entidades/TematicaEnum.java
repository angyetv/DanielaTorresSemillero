package com.hbt.semillero.entidades;

/**
 * Enumerado para representar las posibles tematicas que tiene un comic.
 * 
 * @author Angye Daniela Torres.
 *
 */
public enum TematicaEnum {

	AVENTURAS("enum.tematica.aventuras"), BELICO("enum.tematica.belico"), HUMORISTICO("enum.tematica.humoristico"),
	DEPORTIVO("enum.tematica.deportivo"), FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.ciencia_ficcion"), HISTORICO("enum.tematica.historico"),
	HORROR("enum.tematica.horror");

	/**
	 * Variable que representa el codigo de cada temática.
	 */
	private String codigoMensaje;

	/**
	 * Constructor
	 * 
	 * @param codigoMensaje
	 */
	private TematicaEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Obtener codigo del mensaje.
	 * 
	 * @return
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Cambiar el codigo del mensaje.
	 * 
	 * @param codigoMensaje
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
}
