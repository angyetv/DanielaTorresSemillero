package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.entidad.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina el dto a usar para modificar,
 * consultar y posteriormente eliminar un usuario.
 * 
 * @author Angye Daniela Torres.
 */
public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8671491754930043967L;

	private String id;
	private String nombre;
	private LocalDate fechaCreacion;
	private EstadoEnum estadoEnum;
	private PersonaDTO suIdPersona;

	/**
	 * Constructor vacio.
	 */
	public UsuarioDTO() {
	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param id
	 * @param nombre
	 * @param fechaCreacion
	 * @param estadoEnum
	 * @param suIdPersona
	 */
	public UsuarioDTO(String id, String nombre, LocalDate fechaCreacion, EstadoEnum estadoEnum,
			PersonaDTO suIdPersona) {
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.estadoEnum = estadoEnum;
		this.suIdPersona = suIdPersona;
	}

	/**
	 * Obtener id de usuario.
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Modificar el id de usuario.
	 * 
	 * @param idUsuario
	 */
	public void setId(String idUsuario) {
		this.id = idUsuario;
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
	 * Obtener la fecha de creación del usuario.
	 * 
	 * @return
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Modificar la fecha de creación del usuario.
	 * 
	 * @param fechaCreacion
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Obtener el estado activo e inactivo.
	 * 
	 * @return
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Modificar el estado activo e inactivo.
	 * 
	 * @param estadoEnum
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Obtener el id asociado a una persona.
	 * 
	 * @return
	 */
	public PersonaDTO getSuIdPersona() {
		return suIdPersona;
	}

	/**
	 * Modificar el id asocidado a una persona.
	 * 
	 * @param suIdPersona
	 */
	public void setSuIdPersona(PersonaDTO suIdPersona) {
		this.suIdPersona = suIdPersona;
	}

	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo UsuarioDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static UsuarioDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, UsuarioDTO.class);
	}

	/**
	 * Método encargado de convertir los datos recibidos en UsuarioDTO al JSON
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
		UsuarioDTO other = (UsuarioDTO) obj;
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
