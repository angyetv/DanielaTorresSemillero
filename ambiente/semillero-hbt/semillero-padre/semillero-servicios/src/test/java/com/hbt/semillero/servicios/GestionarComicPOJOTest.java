/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que determina las pruebas realizadas para la
 * creacion de un comic.<b>Caso de Uso:<b>
 * 
 * @author Angye Daniela Torres.
 * @version
 */
public class GestionarComicPOJOTest {

	/**
	 * 
	 * Metodo encargado de probar que se agregan 3 comic, se modifica el comic con
	 * id 2 y se elimina el comic con id 1. <b>Caso de Uso</b>
	 * 
	 * @author Angye Daniela Torres.
	 */
	@Test
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("1", "Dragon Ball Yamcha", "Planeta Cómic",
				TematicaEnum.AVENTURAS, "Manga Shonen", 144, new BigDecimal(2100), "Dragon Garow Lee", Boolean.FALSE,
				LocalDate.now(), EstadoEnum.ACTIVO, 20L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		// se prueba que la lista no sea nula.
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		// se prueba que la lista no esta vacia
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		// otra forma de probar que la lista no esta vacía
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);

		comicDTO = new ComicDTO();

		comicDTO.setId("2");
		comicDTO.setNombre("Captain America Corps 1-5 USA");
		comicDTO.setEditorial("Panini Comics");
		comicDTO.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO.setColeccion("BIBLIOTECA MARVEL");
		comicDTO.setNumeroPaginas(128);
		comicDTO.setPrecio(new BigDecimal(5000));
		comicDTO.setAutores("Phillippe Briones, Roger Stern");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(5L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		// se prueba que el tamaño de la lista sea 2 posterior a agregar un segundo
		// comic
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);

		comicDTO = new ComicDTO();

		comicDTO.setId("3");
		comicDTO.setNombre("The Spectacular Spider-Man v2 USA");
		comicDTO.setEditorial("Panini Comics");
		comicDTO.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO.setColeccion("MARVEL COMICS");
		comicDTO.setNumeroPaginas(208);
		comicDTO.setPrecio(new BigDecimal(6225));
		comicDTO.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.INACTIVO);
		comicDTO.setCantidad(0L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		// se prueba que el tamaño de la lista sea 3 posterior a agregar un tercer comic
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);

		// nombre nuevo que se le va a asignar al comic 2
		String nuevoNombre = "Captain America Corps 1-5 USA Modificado";

		// modificacion al segundo comic
		gestionarComicPOJO.modificarComicDTO("2", nuevoNombre);

		// se verifica que el nombre del segundo comic en la lista concuerde con el
		// nombre modificado
		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(1).getNombre(), nuevoNombre);

		// se elimina el comic con id 1
		gestionarComicPOJO.eliminarComicDTO("1");

		// se verifica que el tamaño de la lista sea 2 posterior a la eliminar
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);

	}
}