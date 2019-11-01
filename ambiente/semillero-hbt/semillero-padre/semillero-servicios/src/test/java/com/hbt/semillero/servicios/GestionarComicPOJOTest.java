/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Cesar
 * @version
 */
public class GestionarComicPOJOTest {

	/**
	 * 
	 * Metodo encargado de probar que se agregan 3 comic, se modifica el comic con
	 * id 2 y se elimina el comic con id 1. <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 *
	 */
	@Test
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("1", "Dragon Ball Yamcha", "Planeta C�mic", "AVENTURAS",
				"Manga Shonen", 144, new BigDecimal(2100), "Dragon Garow Lee", Boolean.FALSE, LocalDate.now(), "ACTIVO",
				20L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertNotNull(gestionarComicPOJO.getListaComics());// se prueba que la lista no es nula
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());// se prueba que la lista no esta vacia
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);// otra forma de probar que la lista no esta
																			// vacia

		comicDTO = new ComicDTO();

		comicDTO.setId("2");
		comicDTO.setNombre("Captain America Corps 1-5 USA");
		comicDTO.setEditorial("Panini Comics");
		comicDTO.setTematica("FANTASTICO");
		comicDTO.setColeccion("BIBLIOTECA MARVEL");
		comicDTO.setNumeroPaginas(128);
		comicDTO.setPrecio(new BigDecimal(5000));
		comicDTO.setAutores("Phillippe Briones, Roger Stern");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado("ACTIVO");
		comicDTO.setCantidad(5L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);// se prueba que el tamaño de la lista sea 2
																			// posterior a agregar un segundo comic

		comicDTO = new ComicDTO();

		comicDTO.setId("3");
		comicDTO.setNombre("The Spectacular Spider-Man v2 USA");
		comicDTO.setEditorial("Panini Comics");
		comicDTO.setTematica("FANTASTICO");
		comicDTO.setColeccion("MARVEL COMICS");
		comicDTO.setNumeroPaginas(208);
		comicDTO.setPrecio(new BigDecimal(6225));
		comicDTO.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado("INACTIVO");
		comicDTO.setCantidad(0L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);// se prueba que el tamaño de la lista sea 3
																			// posterior a agregar un tercer comic

		String nuevoNombre = "Captain America Corps 1-5 USA Modificado";// nombre nuevo que se le va a asignar al comic
																		// 2
		gestionarComicPOJO.modificarComicDTO("2", nuevoNombre);// modificacion al segundo comic

		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(1).getNombre(), nuevoNombre);// se verifica que el
																									// nombre del
																									// segundo comic en
																									// la lista
																									// concuerde con el
																									// nombre modificado

		gestionarComicPOJO.eliminarComicDTO("1");// se elimina el comic con id 1

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);// se verifica que el tamaño de la lista sea
																			// 2 posterior a la eliminar

	}
}