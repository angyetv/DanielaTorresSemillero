/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

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
 * @version
 */
@Stateless
public class GestionarComicBean {

	@PersistenceContext
	private EntityManager em;

	// TODO
	/*
	 * agregar interfaz
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComicDTO(ComicDTO comicNuevo) {
		// Entidad nueva
		Comic comic = new Comic();
		comic.setId(comicNuevo.getId());
		// TODO llenar los demas datos
		em.persist(comicNuevo);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		comic.setId(comicModificar.getId());
		// TODO llenar los demas datos
		em.merge(comic);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) {
		Comic comic = em.find(Comic.class, idComic);
		ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());
		// TODO llenar los demas datos
		return comicDTO;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComic() {
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}
}
