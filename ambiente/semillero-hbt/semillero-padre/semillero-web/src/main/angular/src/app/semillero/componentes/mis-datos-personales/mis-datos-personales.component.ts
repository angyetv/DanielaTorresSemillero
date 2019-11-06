import { Component, OnInit } from '@angular/core';

/**
 * @description Componente que contiene la información personal. Ejercicio 1.
 * @author Angye Daniela Torres Veloza <angye.torres@uptc.edu.co>
 */
@Component({
  selector: 'app-mis-datos-personales',
  templateUrl: './mis-datos-personales.component.html',
  styleUrls: ['./mis-datos-personales.component.css']
})
export class MisDatosPersonalesComponent implements OnInit {

  /**
   * Atributo que define el nombre.
   */
  nombre: string;

  /**
   * Atributo que define la ciudad.
   */
  ciudad: string;

  /**
   * Atributo que define la url de GitHub.
   */
  urlGitHub: string;

  /**
   * Método constructor.
   */
  constructor() { }

  /**
   * Método Oninit.
   */
  ngOnInit() {
    this.nombre = 'Angye Daniela Torres Veloza';
    this.ciudad = 'Tunja';
    this.urlGitHub = 'https://github.com/angyetv/DanielaTorresSemillero.git';
  }
}
