package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * <b>Descripción:<b> Clase que determina el dto a usar para modificar,
 * consultar y posteriormente eliminar una persona.
 * 
 * @author Angye Daniela Torres.
 */
public class PersonaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4742014270524193118L;

	private String id;
	private String nombre;
	private String numeroCedula;

	public PersonaDTO() {
	}

	/**
	 * Obtener el id.
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Modificar el id.
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtener el nombre.
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modificar el nombre.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener el numero de cedula
	 * 
	 * @return
	 */
	public String getNumeroCedula() {
		return numeroCedula;
	}

	/**
	 * Modificar el numero de cedula.
	 * 
	 * @param numeroCedula
	 */
	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo PersonaDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static PersonaDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, PersonaDTO.class);
	}

	/**
	 * Método encargado de convertir los datos recibidos en PersonaDTO al JSON
	 * esperado
	 * 
	 * @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaDTO other = (PersonaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
