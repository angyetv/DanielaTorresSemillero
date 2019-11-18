package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Usuario;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los usuarios.
 * 
 * @author Angye Daniela Torres.
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarUsuarioBean implements IGestionarUsuarioLocal {

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	@Override
	public void crearUsuario(UsuarioDTO usuarioNuevo) {

		Usuario usuario = convertirComicDTOToComic(usuarioNuevo);
		usuario.setNombre(crearNombreDeUsuario(usuarioNuevo.getNombre()));
		// Se almacena la informacion y se maneja la enidad comic
		em.persist(usuario);
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarUsuario(Long id, String nombre, UsuarioDTO usuarioNuevo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public UsuarioDTO consultarUsuario(String idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioDTO> consultarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private UsuarioDTO convertirUsuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		if (usuario.getIdUsuario() != null) {
			usuarioDTO.setId(usuario.getIdUsuario().toString());
		}
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
		usuarioDTO.setEstadoEnum(usuario.getEstadoEnum());
		usuarioDTO.setSuIdPersona((usuario.getSuIdPersona().toString()));
		return usuarioDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un UsuarioDTO a un Usuario
	 * 
	 * @param comic
	 * @return
	 */
	private Usuario convertirComicDTOToComic(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		if (usuarioDTO.getId() != null) {
			usuario.setIdUsuario(Long.parseLong(usuarioDTO.getId()));
		}
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		usuario.setEstadoEnum(usuarioDTO.getEstadoEnum());
		usuario.setSuIdPersona(Long.parseLong(usuarioDTO.getSuIdPersona()));
		return usuario;
	}

	private static String crearNombreDeUsuario(String nombre) {
		String nuevoNombre = "";
		int aleatorio = (int) (Math.random() * 8) + 1;
		if (nombre.toCharArray().length < 7) {
			nuevoNombre += String.valueOf(nombre.charAt(0)).toUpperCase() + aleatorio;
			for (int i = 1; i < nombre.length(); i++) {
				nuevoNombre += nombre.charAt(i);
			}
		}
		return nuevoNombre;
	}

	public static void main(String[] args) {
		System.out.println(GestionarUsuarioBean.crearNombreDeUsuario("Diana"));
	}
}
