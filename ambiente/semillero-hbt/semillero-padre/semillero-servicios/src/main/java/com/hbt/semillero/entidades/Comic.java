package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * Clase que representa un comic.
 * 
 * @author Angye Daniela Torres Veloza.
 * @version 1.
 */
@Entity
@Table(name = "COMIC")
public class Comic implements Serializable {

	private static final long serialVersionUID = 4322034079745146450L;

	/**
	 * Id del comic.
	 */
	private String id;

	/**
	 * Representa el nombre.
	 */
	private String nombre;

	/**
	 * Determina el editorial.
	 */
	private String editorial;

	/**
	 * Determina la temática especifica de un Comic.
	 */
	private TematicaEnum tematicaEnum;

	/**
	 * Determina la colección.
	 */
	private String coleccion;

	/**
	 * Determina el numero de paginas.
	 */
	private Integer numeroPaginas;

	/**
	 * Determina el precio.
	 */
	private BigDecimal precio;

	/**
	 * Determina los autores.
	 */
	private String autores;

	/**
	 * Determina el color.
	 */
	private Boolean color;

	/**
	 * Determina la fecha de venta.
	 */
	private LocalDate fechaVenta;

	/**
	 * Determina el estado activo e inactivo.
	 */
	private EstadoEnum estadoEnum;

	/**
	 * Determina la cantidad.
	 */
	private Long cantidad;

	/**
	 * Constructor vacio.
	 */
	public Comic() {
	}

	/**
	 * Constructor con todos los atributos de la clase.
	 * 
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematicaEnum
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estadoEnum
	 * @param cantidad
	 */
	public Comic(String id, String nombre, String editorial, TematicaEnum tematicaEnum, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta,
			EstadoEnum estadoEnum, Long cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematicaEnum = tematicaEnum;
		this.coleccion = coleccion;
		this.numeroPaginas = numeroPaginas;
		this.precio = precio;
		this.autores = autores;
		this.color = color;
		this.fechaVenta = fechaVenta;
		this.estadoEnum = estadoEnum;
		this.cantidad = cantidad;
	}

	/**
	 * Metodo para obtener el id.
	 * 
	 * @return
	 */
	@Id
	@Column(name = "SCID")
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo para obtener el nombre.
	 * 
	 * @return
	 */
	@Column(name = "SCNOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para editar el nombre.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo para obtener el editorial.
	 * 
	 * @return
	 */
	@Column(name = "SCEDITORIAL")
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo para editar el editorial.
	 * 
	 * @return
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo para obtener la tematica.
	 * 
	 * @return
	 */
	@Column(name = "SCTEMATICA")
	@Enumerated(value = EnumType.STRING)
	public TematicaEnum getTematicaEnum() {
		return tematicaEnum;
	}

	/**
	 * Metodo para editar la Temática.
	 * 
	 * @param nombre
	 */
	public void setTematicaEnum(TematicaEnum tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}

	/**
	 * Metodo para obtener la colección.
	 * 
	 * @return
	 */
	@Column(name = "SCCOLECTION")
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Metodo para editar la colección.
	 * 
	 * @param coleccion
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Metodo para obtener el numero de paginas.
	 * 
	 * @return
	 */
	@Column(name = "SCNUMEROPAGINAS")
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Metodo para ediar el numero de paginas.
	 * 
	 * @param numeroPaginas
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Metodo para obtener el precio.
	 * 
	 * @return
	 */
	@Column(name = "SCPRECIO")
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo para cambiar el precio.
	 * 
	 * @param nombre
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo para obtener los autores.
	 * 
	 * @return
	 */
	@Column(name = "SCAUTORES")
	public String getAutores() {
		return autores;
	}

	/**
	 * Metodo para cambiar los autores.
	 * 
	 * @param nombre
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Metodo para obtener el color.
	 * 
	 * @return
	 */
	@Column(name = "SCCOLOR")
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo para cambiar el color.
	 * 
	 * @param nombre
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo para obtener la fecha de venta.
	 * 
	 * @return
	 */
	@Column(name = "SCFECHA_VENTA")
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo para cambiar la fecha de venta.
	 * 
	 * @param nombre
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo para obtener el estado del enumerado.
	 * 
	 * @return
	 */
	@Column(name = "SCESTADO")
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Metodo para cambiar el estado activo o inactivo.
	 * 
	 * @param nombre
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Metodo para obtener la cantidad.
	 * 
	 * @return
	 */
	@Column(name = "SCCANTIDAD")
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo para cambiar la cantindad.
	 * 
	 * @param nombre
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Método toString con todos los atributos de la clase.
	 */
	@Override
	public String toString() {
		return "Comic [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", tematicaEnum=" + tematicaEnum
				+ ", coleccion=" + coleccion + ", numeroPaginas=" + numeroPaginas + ", precio=" + precio + ", autores="
				+ autores + ", color=" + color + ", fechaVenta=" + fechaVenta + ", estadoEnum=" + estadoEnum
				+ ", cantidad=" + cantidad + "]";
	}

	/**
	 * Metodo hasCode con todos los atrubutos de la clase.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((coleccion == null) ? 0 : coleccion.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + ((estadoEnum == null) ? 0 : estadoEnum.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroPaginas == null) ? 0 : numeroPaginas.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((tematicaEnum == null) ? 0 : tematicaEnum.hashCode());
		return result;
	}

	/**
	 * Metodo Equals con todos los atributos de la clase.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comic other = (Comic) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (coleccion == null) {
			if (other.coleccion != null)
				return false;
		} else if (!coleccion.equals(other.coleccion))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (estadoEnum == null) {
			if (other.estadoEnum != null)
				return false;
		} else if (!estadoEnum.equals(other.estadoEnum))
			return false;
		if (fechaVenta == null) {
			if (other.fechaVenta != null)
				return false;
		} else if (!fechaVenta.equals(other.fechaVenta))
			return false;
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
		if (numeroPaginas == null) {
			if (other.numeroPaginas != null)
				return false;
		} else if (!numeroPaginas.equals(other.numeroPaginas))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (tematicaEnum == null) {
			if (other.tematicaEnum != null)
				return false;
		} else if (!tematicaEnum.equals(other.tematicaEnum))
			return false;
		return true;
	}
}
