/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina los servicios rest. <b>Caso de Uso:<b>
 * 
 * @author Angye Daniela Torres.
 * @version
 */
@Path("/GestionarComic")
public class GestionarComicRest {

	@EJB
	private IGestionarComicLocal gestionarComicEJB;

	/**
	 * Recibe la petición de un hola mundo.
	 * 
	 * @author Angye Daniela Torres.
	 * @return
	 */
	@GET // Tipo de evio.
	@Path("/saludo") // Ruta de acceso.
	@Produces(MediaType.APPLICATION_JSON) // Define el tipo de recurso que se va a retornar.
	public String primerRest() {
		return "Hola Mundo";
	}

	/**
	 * Recibe la petición para consultar un comic por id.
	 * 
	 * @author Angye Daniela Torres.
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic") // ruta de acceso
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if (idComic != null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}
}
