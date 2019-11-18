package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidad.Persona;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * las personas
 * 
 * @author Angye Daniela Torres.
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonaBean implements IGestionarPersonaLocal {

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public void crearPersona(PersonaDTO personaNueva) {
		Persona persona = convertirPersonaDTOToPersona(personaNueva);
		em.persist(persona);
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComic(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public PersonaDTO consultarPersona(String idPersona) {
		Persona persona = null;
		persona = new Persona();
		persona = em.find(Persona.class, Long.parseLong(idPersona));
		PersonaDTO personaDTO = convertirPersonaToPersonaDTO(persona);
		return personaDTO;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosPersonasDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultados = em.createQuery("select p from TC_PERSONA p").getResultList();
		for (Persona persona:resultados) {
			resultadosPersonasDTO.add(convertirPersonaToPersonaDTO(persona));
		}
		return resultadosPersonasDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar una persona a una personaDTO
	 * 
	 * @param persona
	 * @return
	 */
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if (persona.getId() != null) {
			personaDTO.setId(persona.getId().toString());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumeroCedula(persona.getNumeroCedula().toString());
		return personaDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un personaDTO a un persona
	 * 
	 * @param persona
	 * @return
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if (personaDTO.getId() != null) {
			persona.setId(Long.parseLong(personaDTO.getId()));
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setNumeroCedula(Long.parseLong(personaDTO.getNumeroCedula()));
		return persona;
	}
}
