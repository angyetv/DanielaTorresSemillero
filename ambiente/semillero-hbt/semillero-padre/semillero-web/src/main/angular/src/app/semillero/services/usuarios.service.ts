import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './template.service';
import { Observable } from 'rxjs';
import { PersonaDTO } from '../dto/persona.dto';

@Injectable({
  providedIn: 'root'
})
/**
 * Servicio que gestiona las CRUD de personas y usuarios.
 */
export class UsuariosService extends AbstractService {

  /**
   * Constructor del servicio, inicializa injector.
   * @param injector
   * @param httpClient
   */
  constructor(injector: Injector, private httpClient: HttpClient) {
    super(injector);
  }


  /**
   *
   * @param personaDTO metodo que crea un usuario a partir de una persona DTO.
   */
  public crearUsuario(personaDTO: PersonaDTO) {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/crearUsuario', personaDTO);
  }

  /**
   * metodo que permite consultar la lista de personas inscritas en la base de datos.
   */
  public consultarPersonas(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarPersonas');
  }

  /**
   * metodo que permite consultar la lista de usuarios inscritos con estado activo.
   */
  public consultarUsuarios(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuarios');
  }

  /**
   * metodo que permite modificar un usuario.
   * @param usuarioDTO
   */
  public modificarUsuario(idUsuario: number, nombre: string) {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/modificar', { 'idUsuario': idUsuario, 'nombre': nombre });
  }

  /**
   * metodo que permite invalidar a un usuario cambiandole el estado ACTIVO a INACTIVO.
   * @param idUsuario
   */
  public eliminarUsuario(idUsuario: number) {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/invalidar?idUsuario=' + idUsuario);
  }
}
