/**
 * TematicaEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina los posibles valores de tematicas en
 * comics <b>Caso de Uso:<b>
 * 
 * @author Angye Daniela Torres.
 * @version
 */
public enum TematicaEnum {

	AVENTURAS("enum.tematica.aventuras"), BELICO("enum.tematica.belico"), HUMORISTICO("enum.tematica.humoristico"),
	DEPORTIVO("enum.tematica.deportivo"), FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.cienciaficcion"), HISTORICO("enum.tematica.historico"),
	HORROR("enum.tematica.horror");

	private String codigoMensaje;

	/**
	 * Constructor de la clase.
	 * 
	 * @param codigoMensaje
	 */
	private TematicaEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigoMensaje
	 * 
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigoMensaje
	 * 
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
}
