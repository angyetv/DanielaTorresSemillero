package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.UsuarioDTO;

/**
 * Expone los métodos del EJB GestionarUsuario Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Angye Daniela Torres.
 */
@Local
public interface IGestionarUsuarioLocal {

	/**
	 * 
	 * Metodo encargado de crear un usuario y persistirlo
	 * 
	 * @author Angye Daniela Torres.
	 * @param usuarioNuevo informacion nueva a crear
	 */
	public void crearUsuario(UsuarioDTO usuarioNuevo) throws Exception;

	/**
	 * 
	 * Metodo encargado de consultar un Usuario modificarlo y guardarlo
	 * 
	 * @author Angye Daniela Torres.
	 * @param usuarioModificar informacion nueva a modificar
	 */
	public UsuarioDTO modificarNombreUsuario(Long id, String nombre, UsuarioDTO usuarioDTONuevo) throws Exception;

	/**
	 * 
	 * Metodo encargado de cambiar el estado de un usuario de ACTIVO a INACTIVO
	 * 
	 * @author Angye Daniela Torres.
	 * @param idUsuario
	 */
	public UsuarioDTO invalidarUsuario(Long idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un Usuario
	 * 
	 * @param idUsuario identificador del Usuario a ser consultado
	 * @return Usuario Resultado de la consulta
	 * @throws Exception si no se recibe idUsuario
	 */
	public UsuarioDTO consultarUsuario(Long idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar una lista de Usuarios con estado activo.
	 * 
	 * @return Lista de usuarios creados.
	 */
	public List<UsuarioDTO> consultarUsuarios();

	/**
	 * Metodo encargado de crear una nueva persona <b>Caso de Uso</b>
	 * 
	 * @param personaDTO
	 */
	public void crearPersona(PersonaDTO personaDTO);

	/**
	 * Metodo encargado de consultar la lista de personas agregadas. <b>Caso de
	 * Uso</b>
	 * 
	 * @return lista de personas.
	 */
	public List<PersonaDTO> consultarPersonas();
}
