package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Clase que determina la representación de un Comic DTO.
 * 
 * @author Angye Daniela Torres Veloza.
 * @version 1.
 */
public class ComicDTO implements Serializable {

	/**
	 * Variable que serializa la calse.
	 */
	private static final long serialVersionUID = -1183728090299162575L;

	/**
	 * Id del título.
	 */
	private String scid;

	/**
	 * Variable que representa el nombre del comic.
	 */
	private String nombre;

	/**
	 * Variable que representa el editorial.
	 */
	private String editorial;

	/**
	 * Variable que representa la temática.
	 */
	private String tematica;

	/**
	 * Variable que representa la colección.
	 */
	private String coleccion;

	/**
	 * Variable que representa el precio.
	 */
	private BigDecimal precio;

	/**
	 * Variable que representa los autores.
	 */
	private String autores;

	/**
	 * Variable que representa el color.
	 */
	private boolean color;

	/**
	 * Variable que represnta la fecha de venta.
	 */
	private LocalDate fechaVenta;

	/**
	 * Variable que represnta el estado.
	 */
	private String estado; // TODO

	/**
	 * Variable que representa la cantidad de comic.
	 */
	private Long cantidad;

	/**
	 * Metodo contructor vacio.
	 */
	public ComicDTO() {

	}

	/**
	 * Metodo constructor con todos los parametros de la clase.
	 * 
	 * @param scid
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 */
	public ComicDTO(String scid, String nombre, String editorial, String tematica, String coleccion, BigDecimal precio,
			String autores, boolean color, LocalDate fechaVenta, String estado, Long cantidad) {
		this.scid = scid;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematica = tematica;
		this.coleccion = coleccion;
		this.precio = precio;
		this.autores = autores;
		this.color = color;
		this.fechaVenta = fechaVenta;
		this.estado = estado;
		this.cantidad = cantidad;
	}

	/**
	 * Metodo constructor con id y nombre.
	 * 
	 * @param scid
	 * @param nombre
	 */
	public ComicDTO(String scid, String nombre) {
		this.scid = scid;
		this.nombre = nombre;
	}

	/**
	 * Get Id.
	 * 
	 * @return
	 */
	public String getScid() {
		return scid;
	}

	/**
	 * Sed Id.
	 * 
	 * @param scid
	 */
	public void setScid(String scid) {
		this.scid = scid;
	}

	/**
	 * Get Nombre.
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Set Nombre.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Get Editorial.
	 * 
	 * @return
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Set Editorial.
	 * 
	 * @param editorial
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Get TematicaEnum
	 * 
	 * @return
	 */
	public String getTematicaEnum() {
		return tematica;
	}

	/**
	 * Set Temática Enum
	 * 
	 * @param tematicaEnum
	 */
	public void setTematicaEnum(String tematicaEnum) {
		this.tematica = tematicaEnum;
	}

	/**
	 * Get colección
	 * 
	 * @return
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Set Colección
	 * 
	 * @param coleccion
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Get Precio
	 * 
	 * @return
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Set precio
	 * 
	 * @param precio
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Get Autores.
	 * 
	 * @return
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Set Autores.
	 * 
	 * @param autores
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Obtener el color.
	 * 
	 * @return
	 */
	public boolean isColor() {
		return color;
	}

	/**
	 * Cambiar el color.
	 * 
	 * @param color
	 */
	public void setColor(boolean color) {
		this.color = color;
	}

	/**
	 * Get Fecha de Venta
	 * 
	 * @return
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Set Fecha de Venta
	 * 
	 * @param fechaVenta
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Get Estado
	 * 
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Set Estado
	 * 
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Get Cantidad
	 * 
	 * @return
	 */
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * Set Cantidad.
	 * 
	 * @param cantidad
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
}