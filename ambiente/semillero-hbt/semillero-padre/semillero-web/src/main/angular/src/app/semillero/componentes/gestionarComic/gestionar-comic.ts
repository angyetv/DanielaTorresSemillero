import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

/**
 * @description Componenete que permite gestionar comics, contiene crear, editar, eliminar, visualizar.
 *
 * @author Angye Daniela Torres <angye.torres@uptc.edu.co>.
 */
@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.html',
  styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

  /**
   * Atributo que contiene los controles del formulario
   */
  public gestionarComicForm: FormGroup;

  /**
   * Atributo que contendra la informacion del comic
   */
  public comic: ComicDTO;

  /**
   * Atributo que contendra la lista de comics creados
   */
  public listaComics: Array<ComicDTO>;

  public idComic: number = 0;

  /**
   * variable que establece si se esta editando un comic o no
   */
  public editando: boolean;

  /**
   *  id del comic que se esta editando
   */
  public idComicToEdit: number;
  /**
   * Atributo que indica si se envio a validar el formulario
   */
  public submitted: boolean;

  /**
   * @description Este es el constructor del componente GestionarComicComponent
   * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
   */
  constructor(private fb: FormBuilder,
    private router: Router) {
    this.gestionarComicForm = this.fb.group({
      nombre: [null, Validators.required],
      editorial: [null],
      tematica: [null],
      coleccion: [null],
      numeroPaginas: [null],
      precio: [null],
      autores: [null],
      color: [null]
    });
  }

  /**
   * @description Evento angular que se ejecuta al invocar el componente
   * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
   */
  ngOnInit(): void {
    this.comic = new ComicDTO();
    this.listaComics = new Array<ComicDTO>();
  }

  /**
   * @description Metodo que permite validar el formulario y crear o actulizar un comic
   * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
   */
  public crearActualizarComic(): void {
    this.submitted = true;
    if (this.gestionarComicForm.invalid) {
      return;
    }
    this.comic = new ComicDTO();
    this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
    this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
    this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
    this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
    this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
    this.comic.precio = this.gestionarComicForm.controls.precio.value;
    this.comic.autores = this.gestionarComicForm.controls.autores.value;
    this.comic.color = this.gestionarComicForm.controls.color.value;
    this.limpiarFormulario();
    if (!this.editando) {
      this.idComic++;
      this.comic.id = this.idComic + '';
      this.listaComics.push(this.comic);
    } else {
      for (let i = 0; i < this.listaComics.length; i++) {
        if (this.listaComics[i].id === this.idComicToEdit + '') {
          this.comic.id = this.idComicToEdit + '';
          this.listaComics[i] = this.comic;
          break;
        }
      }
      this.editando = false;
    }
  }

  /**
   * metodo por el cual se puede entrar en el modo de edicion de comic
   * @param comic comic que se desea editar
   * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
   */
  public editarComic(comic: any): void {
    this.idComicToEdit = comic.id;
    this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
    this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
    this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
    this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
    this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
    this.gestionarComicForm.controls.precio.setValue(comic.precio);
    this.gestionarComicForm.controls.autores.setValue(comic.autores);
    this.gestionarComicForm.controls.color.setValue(comic.color);
    this.editando = true;
  }

  /**
   * metodo que permite limpiar el formulario
   * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
   */
  private limpiarFormulario(): void {
    this.submitted = false;
    this.gestionarComicForm.controls.nombre.setValue(null);
    this.gestionarComicForm.controls.editorial.setValue(null);
    this.gestionarComicForm.controls.tematica.setValue(null);
    this.gestionarComicForm.controls.coleccion.setValue(null);
    this.gestionarComicForm.controls.numeroPaginas.setValue(null);
    this.gestionarComicForm.controls.precio.setValue(null);
    this.gestionarComicForm.controls.autores.setValue(null);
    this.gestionarComicForm.controls.color.setValue(null);
  }

  /**
   *
   * @param position posicion del comic que se desea eliminar
   * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
   */
  eliminarComic(position: number) {
    this.listaComics.splice(position, 1);
  }
  /**
   * @description Metodo que obtiene los controles y sus propiedades
   * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
   */
  get f() {
    return this.gestionarComicForm.controls;
  }
}
