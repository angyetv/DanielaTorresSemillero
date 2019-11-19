import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { UsuariosService } from '../../services/usuarios.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { UsuarioDTO } from '../../dto/Usuario.dto';

/**
 * @description Componenete que permite consutar usuarios.
 *
 * @author Angye Daniela Torres <angye.torres@uptc.edu.co>.
 */
@Component({
  selector: 'app-consultar-usuario',
  templateUrl: './consultar-usuario.component.html'
})
export class ConsultarUsuarioComponent implements OnInit {

  /**
   * formulario que representa los datos del usuario
   */
  public gestionarUsuarioForm: FormGroup;

  /**
   * varaible que determina si se esta editando o no el usuario
   */
  public editando: boolean;

  /**
   * metodo constructor del componente
   * @param router
   * @param activatedRoute
   * @param fb
   * @param location
   * @param _usuariosService
   */
  constructor(private router: Router,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private location: Location,
    private _usuariosService: UsuariosService) {
    // inicializacion del formulario de usuario.
    this.gestionarUsuarioForm = this.fb.group({
      nombre: [null],
      fechaCreacion: [null],
      estado: [null],
      idPersona: [null]
    });
  }

  /**
   * se inicializan los valores del usuario deacuerdo a la ruta activada
   */
  ngOnInit() {
    let usuario = this.activatedRoute.snapshot.params;
    this.gestionarUsuarioForm.controls.nombre.setValue(usuario.nombre);
    this.gestionarUsuarioForm.controls.fechaCreacion.setValue(usuario.fechaCreacion);
    this.gestionarUsuarioForm.controls.estado.setValue(usuario.Estado);
    this.gestionarUsuarioForm.controls.idPersona.setValue(usuario.idPersona);
    this.gestionarUsuarioForm.controls.nombre.disable();
    this.gestionarUsuarioForm.controls.fechaCreacion.disable();
    this.gestionarUsuarioForm.controls.estado.disable();
    this.gestionarUsuarioForm.controls.idPersona.disable();
  }

  /**
   * metodo que permite volver a la ubicacion anterior
   */
  volver() {
    this.location.back();
  }

  /**
   * metodo que habilita el campo nombre para edicion y el modo edicion
   */
  entrarEnModoEdicion() {
    this.editando = true;
    this.gestionarUsuarioForm.controls.nombre.enable();
  }

  /**
   * metodo que edita el usuario que se tenga y luego permite volver a la pagina anterior
   */
  editar() {
    let usuario = this.activatedRoute.snapshot.params;
    let usuarioDTO = new UsuarioDTO();
    usuarioDTO.id = usuario.id;
    usuarioDTO.nombre = this.gestionarUsuarioForm.controls.nombre.value;
    usuarioDTO.fechaCreacion = usuario.fechaCreacion;
    usuarioDTO.estado = usuario.Estado;
    usuarioDTO.idPersona = usuario.idPersona;
    this._usuariosService.modificarUsuario(usuarioDTO.id, usuarioDTO.nombre).subscribe();
    this.editando = false;
    this.volver();
  }
}
