package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.Persona;
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

	private static final String CARACTERES_MINUSCULA = "abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITOS = "0123456789";

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearUsuario(com.hbt.semillero.dto.UsuarioDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearUsuario(UsuarioDTO usuarioNuevo) throws Exception {
		String nombreGenerado = generateUserName();
		if (consultarUsuarioPorNombreUsuario(nombreGenerado).isEmpty()) {
			usuarioNuevo.setNombre(nombreGenerado);
			Usuario usuario = convertirUsuarioDTOToUsuario(usuarioNuevo);
			em.persist(usuario);
		} else {
			throw new Exception("Error, el nombre de usuario " + nombreGenerado + " ya está registrado");
		}
	}

	/**
	 * @throws Exception
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#modificarNombreUsuario(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.UsuarioDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public UsuarioDTO modificarNombreUsuario(Long id, String nombre, UsuarioDTO usuarioDTONuevo) throws Exception {
		Usuario usuarioModificar;
		if (usuarioDTONuevo == null) {
			usuarioModificar = em.find(Usuario.class, id);
		} else {
			usuarioModificar = convertirUsuarioDTOToUsuario(usuarioDTONuevo);
		}
		if (elNombreUsuarioEsValido(nombre)) {
			usuarioModificar.setNombre(nombre);
		} else {
			throw new Exception("El nombre no es válido");
		}
		em.merge(usuarioModificar);
		return convertirUsuarioToUsuarioDTO(usuarioModificar);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#inactivarUsuario(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public UsuarioDTO invalidarUsuario(Long idUsuario) {
		Usuario usuario = em.find(Usuario.class, idUsuario);
		if (usuario.getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
			usuario.setEstadoEnum(EstadoEnum.INACTIVO);
			em.merge(usuario);
		}
		return convertirUsuarioToUsuarioDTO(usuario);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarUsuario(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UsuarioDTO consultarUsuario(Long idUsuario) {
		Usuario usuario = em.find(Usuario.class, idUsuario);
		UsuarioDTO usuarioDTO = convertirUsuarioToUsuarioDTO(usuario);
		return usuarioDTO;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarUsuarios()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UsuarioDTO> consultarUsuarios() {
		List<UsuarioDTO> resultadosUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> resultados = em.createQuery("select u from TC_USUARIO u").getResultList();
		for (Usuario usuario : resultados) {
			if (usuario.getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
				resultadosUsuarioDTO.add(convertirUsuarioToUsuarioDTO(usuario));
			}
		}
		return resultadosUsuarioDTO;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearUsuario(com.hbt.semillero.dto.UsuarioTDO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public void crearPersona(PersonaDTO personaDTO) {
		Persona persona = convertirPersonaDTOToPersona(personaDTO);
		em.persist(persona);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarPersonas()
	 */
	@Override
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosUsuarioDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultados = em.createQuery("select p from TC_PERSONA p").getResultList();
		for (Persona persona : resultados) {
			resultadosUsuarioDTO.add(convertirPersonaToPersonaDTO(persona));
		}
		return resultadosUsuarioDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un usuario a un usuarioDTO
	 * 
	 * @param usuario
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
		usuarioDTO.setSuIdPersona(convertirPersonaToPersonaDTO(usuario.getSuIdPersona()));
		return usuarioDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un UsuarioDTO a un Usuario
	 * 
	 * @param usuario
	 * @return
	 */
	private Usuario convertirUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		if (usuarioDTO.getId() != null) {
			usuario.setIdUsuario(Long.parseLong(usuarioDTO.getId()));
		}
		usuario.setIdUsuario(Long.parseLong(usuarioDTO.getId()));
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		usuario.setEstadoEnum(usuarioDTO.getEstadoEnum());
		usuario.setSuIdPersona(convertirPersonaDTOToPersona(usuarioDTO.getSuIdPersona()));
		return usuario;
	}

	/**
	 * 
	 * Metodo encargado de convertir una Persona a PersonaDTO <b>Caso de Uso</b>
	 * 
	 * @author Angye Daniela Torres.
	 * 
	 * @param persona Entidad de tipo Persona a convertir
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
	 * Metodo encargado de convertir una PersonaDTO a Persona <b>Caso de Uso</b>
	 * 
	 * @author Angye Daniela Torres.
	 * 
	 * @param personaDTO
	 * @return
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		persona.setId(Long.parseLong(personaDTO.getId()));
		persona.setNombre(personaDTO.getNombre());
		persona.setNumeroCedula(Long.parseLong(personaDTO.getNumeroCedula()));
		return persona;
	}

	/**
	 * 
	 * Metodo encargado de generar un nombre de usuario aleatorio <b>Caso de Uso</b>
	 * 
	 * @author Angye Daniela Torres.
	 * @return nombre generado.
	 */
	private String generateUserName() {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		int posicion = random.nextInt(CARACTERES_MINUSCULA.toUpperCase().length());
		stringBuilder.append(CARACTERES_MINUSCULA.toUpperCase().charAt(posicion));
		posicion = random.nextInt(DIGITOS.length());
		stringBuilder.append(DIGITOS.charAt(posicion));
		for (int i = 0; i <= random.nextInt(6); i++) {
			posicion = random.nextInt(CARACTERES_MINUSCULA.length());
			stringBuilder.append(CARACTERES_MINUSCULA.charAt(posicion));
		}
		return stringBuilder.toString();
	}

	/**
	 * Si el nombre de usuario es valido retorna true, si no retorna falso. Tiene en
	 * cuenta todas las premisas.
	 * 
	 * @param name
	 * @return
	 */
	private boolean elNombreUsuarioEsValido(String name) {
		return name.length() <= 7 && Character.isUpperCase(name.charAt(0)) && Character.isDigit(name.charAt(1))
				&& name.substring(2, name.length() - 1).chars().allMatch(Character::isLowerCase);
	}

	/**
	 * 
	 * Metodo encargado de consultar si existe uno o más usuarios con el mismo
	 * nombre <b>Caso de Uso</b> x
	 * 
	 * @param nombreUsuario
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarioPorNombreUsuario(String nombreUsuario) {
		List<UsuarioDTO> resultadosUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> resultados = em.createQuery("select u from TC_USUARIO u where u.nombre=:nombre")
				.setParameter("nombre", nombreUsuario).getResultList();
		for (Usuario usuario : resultados) {
			resultadosUsuarioDTO.add(convertirUsuarioToUsuarioDTO(usuario));
		}

		return resultadosUsuarioDTO;
	}
}
