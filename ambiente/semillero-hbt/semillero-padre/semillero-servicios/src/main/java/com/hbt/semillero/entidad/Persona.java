package com.hbt.semillero.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar la
 * tabla "DB_SEMILLERO"."TC_PERSONA"
 * 
 * @author Angye Daniela Torres.
 * @version
 */
@Entity
@Table(name = "TC_PERSONA")
public class Persona implements Serializable {

	/**
	 * Numero serial.
	 */
	private static final long serialVersionUID = 3832688993333798147L;

	private Long id;
	private String nombre;
	private Long numeroCedula;

	/**
	 * Constructor vacio de la clase.
	 */
	public Persona() {
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_SCID_GENERATOR", sequenceName = "SEQ_PERSONA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SCID_GENERATOR")
	@Column(name = "SPID")
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SCNOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo Cedula
	 * 
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SCNUMIDENTIFICACION")
	public Long getNumeroCedula() {
		return numeroCedula;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cedula
	 * 
	 * @param numeroCedula
	 */
	public void setNumeroCedula(Long numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	/**
	 * Metodo que retorna todo el objento a string.
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", numeroCedula=" + numeroCedula + "]";
	}

	/**
	 * Validacion HasCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroCedula == null) ? 0 : numeroCedula.hashCode());
		return result;
	}

	/**
	 * Validacion equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
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
		if (numeroCedula == null) {
			if (other.numeroCedula != null)
				return false;
		} else if (!numeroCedula.equals(other.numeroCedula))
			return false;
		return true;
	}
}
