package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidad.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina el uso de metodos para manipular
 * informacion POJO «Plain Old Java Object», que puede interpretarse como «Un
 * objeto Java Plano». Es una instancia de una clase que no extiende ni
 * implementa nada en particular.
 * 
 * @author Angye Daniela Torres.
 * @version 1.0
 */
public class GestionarUsuarioPOJO {
	/**
	 * Lista que permite reunir un conjunto de usuarios.
	 */
	private List<UsuarioDTO> listaUsuarios = null;

	/**
	 * 
	 * Metodo encargado de crear un nuevo usuario con informacion por defecto.
	 * 
	 * @author Angye Daniela Torres.
	 *
	 */
	public void crearUsuarioDTO() {
		// Se crea e instancia un objeto de tipo UsuarioDTO
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setId("100");
		usuario.setNombre("D1iana");
		usuario.setFechaCreacion(LocalDate.now());
		usuario.setEstadoEnum(EstadoEnum.ACTIVO);
		usuario.setSuIdPersona(new PersonaDTO());

		// Adicionar el usuario creado a la lista de usuarios
		// Se valida primero que la lista este inicializada
		if (listaUsuarios == null) {
			listaUsuarios = new ArrayList<>();
		}
		// Se adiciona el nuevo elmento a la lista
		listaUsuarios.add(usuario);
	}

	/**
	 * 
	 * Metodo encargado de cambiar el estado de un usuario con el mismo id.
	 * 
	 * @author Angye Daniela Torres.
	 * 
	 * @param usuarioModificar
	 */
	public void modificarUsuarioDTO(UsuarioDTO usuarioModificar) {
		// validacion que permite determinar si una lista esta inicializada y tiene
		// elementos
		if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
			int i = 0;
			// ciclo while que permite recorrerer una lista
			// iniciando desde cero hasta el tamaño de la lista de usuarios.
			while (i <= listaUsuarios.size()) {
				if (listaUsuarios.get(i).getId().equals(usuarioModificar.getId())) {
					listaUsuarios.get(i).setEstadoEnum(usuarioModificar.getEstadoEnum());
					listaUsuarios.get(i).setNombre(usuarioModificar.getNombre());
				}
				// atributo que permite incrementar el iterador
				// permite controlar cuando se termine el ciclo o
				// cuando terminar
				i++;
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de eliminar un elemento determinado de la lista de usuarios
	 * 
	 * @author Angye Daniela Torres.
	 * @param usuarioEliminar
	 */
	public void eliminarUsuarioDTO(UsuarioDTO usuarioEliminar) {
		// validacion que permite determinar si una lista esta inicializada y tiene
		// elementos
		if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
			int i = 0;
			// ciclo while que permite recorrerer una lista
			// iniciando desde cero hasta el tamaño de la lista de usuarios.
			while (i <= listaUsuarios.size()) {
				if (listaUsuarios.get(i).getId().equals(usuarioEliminar.getId())) {
					listaUsuarios.get(i).setEstadoEnum(EstadoEnum.INACTIVO);
				}
				// atributo que permite incrementar el iterador
				// permite controlar cuando se termine el ciclo o
				// cuando terminar
				i++;
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de retornar una usuario dado un id determinado
	 * 
	 * @author Angye Daniela Torres.
	 * @param idUsuario identificador del usuario a ser buscado
	 * @return usuario encontrada
	 */
	public UsuarioDTO consultarUsuarioDTO(String idUsuario) {
		// validacion que permite determinar si una lista esta inicializada y tiene
		// elementos
		if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
			// ciclo for
			for (int i = 0; i <= listaUsuarios.size(); i++) {
				if (listaUsuarios.get(i).getId().equals(idUsuario)) {
					return listaUsuarios.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaUsuarios
	 * 
	 * @author Angye Daniela Torres.
	 * @return El listaUsuarios asociado a la clase
	 */
	public List<UsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaUsuarios
	 * 
	 * @author Angye Daniela Torres.
	 * @param listaUsuarios El nuevo listaUsuarios a modificar.
	 */
	public void setListaUsuarios(List<UsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
