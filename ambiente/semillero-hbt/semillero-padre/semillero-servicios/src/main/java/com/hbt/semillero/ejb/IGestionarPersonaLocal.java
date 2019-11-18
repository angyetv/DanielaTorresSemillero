package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;

/**
 * Expone los métodos del EJB GestionarPersona Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Angye Daniela Torres.
 */
@Local
public interface IGestionarPersonaLocal {

	/**
	 * 
	 * Metodo encargado de crear una persona y persistirla
	 * 
	 * @author Angye Daniela Torres.
	 * @param personaNueva informacion nueva a crear
	 */
	public void crearPersona(PersonaDTO personaNueva);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de una persona
	 * 
	 * @author Angye Daniela Torres.
	 * @param idPersona identificador de la persona a ser consultado
	 * @return persona Resultado de la consulta
	 * @throws Exception si no se recibe idPersona
	 */
	public PersonaDTO consultarPersona(String idPersona);

	/**
	 * 
	 * Metodo encargado de retornar una lista de personas
	 * 
	 * @author Angye Daniela Torres.
	 * @return lista de personas incritas.
	 */
	public List<PersonaDTO> consultarPersonas();
}
