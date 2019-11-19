import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../../dto/persona.dto';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuarioDTO } from '../../dto/Usuario.dto';
import { Router } from '@angular/router';
import { UsuariosService } from '../../services/usuarios.service';

/**
 * @description Componenete que permite gestionar usuarios y su formulario.
 *
 * @author Angye Daniela Torres <angye.torres@uptc.edu.co>.
 */
@Component({
  selector: 'app-gestionar-usuarios',
  templateUrl: './gestionar-usuarios.component.html'
})
export class GestionarUsuariosComponent implements OnInit {

  /**
    * Atributo que contiene los controles del formulario
    */
  public gestionarPersonaForm: FormGroup;

  /**
   * Atributo que contendra la informacion de la persona
   */
  public persona: PersonaDTO;

  /**
   * lista de personas que se tienen en la base de datos
   */
  public listaPersonas: Array<PersonaDTO>;

  /**
   * lista de usuarios que se tienen en la base de datos
   */
  public listaUsuarios: Array<UsuarioDTO>;

  /**
   * id que se autoincrementara para ser asignado como id de persona y usuario nuevo dado
   * que en la base de datos no se tiene un autoincremento especificado y este debe ser
   * establecido manualmente
   */
  public id: number = 0;

  /**
   * Atributo que indica si se envio a validar el formulario
   */
  public submitted: boolean;

  /**
   * constructor del componente
   * @param fb
   * @param router
   * @param _usuarioService
   */
  constructor(private fb: FormBuilder,
    private router: Router,
    private _usuarioService: UsuariosService) {
    this.gestionarPersonaForm = this.fb.group({
      SCNOMBRE: [null, Validators.required],
      SCNUMIDENTIFICACION: [null, Validators.required]
    });
  }

  /**
   * se inicializan las listas y se carga lo que se tenga de estas en la base de datos
   */
  ngOnInit() {
    this.persona = new PersonaDTO();
    this.listaPersonas = new Array<PersonaDTO>();
    this.listaUsuarios = new Array<UsuarioDTO>();
    this.loadList();
  }

  /**
   * metodo que va a la base de datos y obtiene la lista de usuarios y de personas
   */
  loadList() {
    this._usuarioService.consultarUsuarios().subscribe(data => {
      this.listaUsuarios = data;
    });
    this._usuarioService.consultarPersonas().subscribe(data => {
      this.listaPersonas = data;
    });
  }

  /**
   * metodo que crea una persona y luego llama al servicio que la añade a la
   * base de datos y que posteriormente crea un usuario en concordancia
   */
  crearPersonaUsuario(): void {
    this.submitted = true;
    this.persona = new PersonaDTO();
    this.persona.id = this.id++;
    this.persona.nombre = this.gestionarPersonaForm.controls.SCNOMBRE.value;
    this.persona.numIdentificacion = this.gestionarPersonaForm.controls.SCNUMIDENTIFICACION.value;
    this._usuarioService.crearUsuario(this.persona).subscribe(data => {
      this.loadList();
    });
    this.limpiarFormulario();
  }

  /**
  * metodo que permite limpiar el formulario
  * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
  */
  private limpiarFormulario(): void {
    this.submitted = false;
    this.gestionarPersonaForm.controls.SCNOMBRE.setValue(null);
    this.gestionarPersonaForm.controls.SCNUMIDENTIFICACION.setValue(null);
  }

  /**
   * metodo que vuelve inactivo un usuario llamando al servicio
   * @param idUsuario
   */
  public eliminarUsuario(idUsuario): void {
    this._usuarioService.eliminarUsuario(idUsuario).subscribe();
    this.loadList();
  }
}
