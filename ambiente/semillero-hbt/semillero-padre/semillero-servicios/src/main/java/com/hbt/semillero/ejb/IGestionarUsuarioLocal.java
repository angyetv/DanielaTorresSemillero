package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

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
	public void crearUsuario(UsuarioDTO usuarioNuevo);

	/**
	 * 
	 * Metodo encargado de consultar un Usuario modificarlo y guardarlo
	 * 
	 * @author Angye Daniela Torres.
	 * @param usuarioModificar informacion nueva a modificar
	 */
	public void modificarUsuario(Long id, String nombre, UsuarioDTO usuarioNuevo);

	/**
	 * 
	 * Metodo encargado de eliminar un Usuario modificarlo y guardarlo
	 * 
	 * @author Angye Daniela Torres.
	 * @param idUsuario informacion a eliminar
	 */
	public void eliminarUsuario(Long idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un Usuario
	 * 
	 * @param idUsuario identificador del Usuario a ser consultado
	 * @return Usuario Resultado de la consulta
	 * @throws Exception si no se recibe idUsuario
	 */
	public UsuarioDTO consultarUsuario(String idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar una lista de Usuarios
	 * 
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarios();
}
