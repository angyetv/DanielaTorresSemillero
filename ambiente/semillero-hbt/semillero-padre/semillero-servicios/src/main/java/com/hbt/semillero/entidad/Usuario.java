package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar la
 * tabla "DB_SEMILLERO"."TC_USUARIO"
 * 
 * @author Angye Daniela Torres.
 * @version
 */
@Entity
@Table(name = "TC_USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3056776955959315420L;

	private Long idUsuario;
	private String nombre;
	private LocalDate fechaCreacion;
	private EstadoEnum estadoEnum;
	private Long suIdPersona;

	public Usuario() {
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "USUARIO_SUID_GENERATOR", sequenceName = "SEQ_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SUID_GENERATOR")
	@Column(name = "SUID")
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Modificar el id de usuario.
	 * 
	 * @param idUsuario
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SUNOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modificar el nombre de usuario.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * 
	 * @return El fechaCreacion asociado a la clase
	 */
	@Column(name = "SUFECHA_CREACION")
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Modificar la fecha de creacion.
	 * 
	 * @param fechaCreacion
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * 
	 * @return El estado asociado a la clase
	 */
	@Column(name = "SUESTADO")
	@Enumerated(value = EnumType.STRING)
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
	 * Metodo encargado de retornar el valor del atributo estado
	 * 
	 * @return El estado asociado a la clase
	 */
	@Column(name = "SUIDPERSONA")
	public Long getSuIdPersona() {
		return suIdPersona;
	}

	/**
	 * Modificar el id de usuario persona.
	 * 
	 * @param suIdPersona
	 */
	public void setSuIdPersona(Long suIdPersona) {
		this.suIdPersona = suIdPersona;
	}

	/**
	 * Convertir el objeto a string.
	 */
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion
				+ ", estadoEnum=" + estadoEnum + ", suIdPersona=" + suIdPersona + "]";
	}

	/**
	 * Metodo HashCode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoEnum == null) ? 0 : estadoEnum.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((suIdPersona == null) ? 0 : suIdPersona.hashCode());
		return result;
	}

	/**
	 * Metodo equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (estadoEnum != other.estadoEnum)
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (suIdPersona == null) {
			if (other.suIdPersona != null)
				return false;
		} else if (!suIdPersona.equals(other.suIdPersona))
			return false;
		return true;
	}
}