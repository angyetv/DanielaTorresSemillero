/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Angye Daniela Torres.
 * @version 1.
 */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal {

	@PersistenceContext
	private EntityManager em;

	// TODO
	/*
	 * agregar interfaz
	 */

	/**
	 * @see com.hbt.semillero.ejb
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {
		// Entidad nueva
		Comic comic = convertirComicDTOToComic(comicDTO);
		em.persist(comic);
	}

	/**
	 * Modificar Comic teniendo en cuenta un comicDTO de parametro.
	 * 
	 * @param comicModificar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		comicModificar.setId(comicModificar.getId());
		// TODO llenar los demas datos
		em.merge(comic);
	}

	/**
	 * Consultar un comc buscando el id del comic.
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) {
		Comic comic = em.find(Comic.class, idComic);
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}

	/**
	 * Consultar comic.
	 * 
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComic() {
		// TODO List<Comic> resultados = (List<Comic>) em.createQuery("select c from
		// Comic").getResultList();
		return null;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	// @TransactionAttribute(TransactionAttributeType.REQUIRED
	// TODO cual es el resultado de llamar a modificar comic
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if (comicNuevo == null) {
			comicModificar = em.find(Comic.class, id);
		} else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		comicModificar.setNombre(nombre);
		em.merge(comicModificar);
	}

	/**
	 * Metodo que se encarga de eliminar un comic luego de buscarlo por id.
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic()
	 */
	@Override
	public void eliminarComic(Long idComic) {
		em.remove(em.find(Comic.class, idComic));
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}

	/**
	 * Metodo que convierte un comicDTO a un Comic
	 * 
	 * @author Angye Daniela Torres.
	 * @param comicDTO
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		if (comicDTO.getId() != null) {
			comic.setId(Long.parseLong(comicDTO.getId()));
		}
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	/**
	 * Metodo encargado de convertir un comic a ComicDTO <b>Caso de Uso</b>
	 * 
	 * @author Angye Daniela Torres.
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setId(comic.getId().toString());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}
}
