package com.hbt.semillero.pojo;

import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.PersonaDTO;

/**
 * <b>Descripción:<b> Clase que determina el uso de metodos para manipular
 * informacion POJO «Plain Old Java Object», que puede interpretarse como «Un
 * objeto Java Plano». Es una instancia de una clase que no extiende ni
 * implementa nada en particular.
 * 
 * @author Angye Daniela Torres.
 * @version 1.0
 */
public class GestionarPersonaPOJO {

	/**
	 * Lista que permite reunir un conjunto de personas.
	 */
	private List<PersonaDTO> listaPersonas = null;

	/**
	 * 
	 * Metodo encargado de crear una nueva persona con informacion por defecto
	 * 
	 * @author Angye Daniela Torres.
	 *
	 */
	public void crearPersonaDTO() {
		// Se crea e instancia un objeto de tipo PersonaDTO
		PersonaDTO persona = new PersonaDTO();
		persona.setId("100");
		persona.setNombre("Diana Torres");
		persona.setNumeroCedula("1036549857");

		// Adicionar la persona creada a la lista de personas
		// Se valida primero que la lista este inicializada
		if (listaPersonas == null) {
			listaPersonas = new ArrayList<>();
		}
		// Se adiciona el nuevo elmento a la lista
		listaPersonas.add(persona);
	}

	/**
	 * 
	 * Metodo encargado de retornar una persona dado un id determinado
	 * 
	 * @author Angye Daniela Torres.
	 * @param idPersona identificador de la persona a ser buscada
	 * @return persona encontrada
	 */
	public PersonaDTO consultarPersonaDTO(String idPersona) {
		// validacion que permite determinar si una lista esta inicializada y tiene
		// elementos
		if (listaPersonas != null && !listaPersonas.isEmpty()) {
			// ciclo for
			for (int i = 0; i <= listaPersonas.size(); i++) {
				if (listaPersonas.get(i).getId().equals(idPersona)) {
					return listaPersonas.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaPersonas
	 * 
	 * @author Angye Daniela Torres.
	 * @return El listaPersonas asociado a la clase
	 */
	public List<PersonaDTO> getListaPersonas() {
		return listaPersonas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaPersonas
	 * 
	 * @author Angye Daniela Torres.
	 * @param listaPersonas El nuevo listaPersonas a modificar.
	 */
	public void setListaPersonas(List<PersonaDTO> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
}
