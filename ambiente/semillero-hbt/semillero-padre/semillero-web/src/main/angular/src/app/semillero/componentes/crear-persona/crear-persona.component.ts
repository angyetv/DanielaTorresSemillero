import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic.dto';

/**
 * @description Componente que contiene la información personal. Ejercicio 1.
 * @author Angye Daniela Torres Veloza <angye.torres@uptc.edu.co>
 */
@Component({
  selector: 'app-crear-persona',
  templateUrl: './crear-persona.component.html'
})
export class CrearPersonaComponent implements OnInit {

  private nombreInstructorGlobalPribado: string;
  public comicDTO: ComicDTO;
  public listaApellidos: Array<any> = new Array<any>();

  constructor() { }

  ngOnInit(): void {
    this.inicializarComponente();
    let miMapa: Map<string, string>;
    miMapa = new Map<string, string>();

    miMapa.set('1', 'semillero');
    miMapa.get('1');
    let miFecha = new Date();
    console.log(miFecha);

    let miVariable: any = {
      id: 1,
      nombre: 'Daniela',
      apello: 'Torres'
    };

    miVariable.genero = 'Femenino';
    delete miVariable.genero;

    this.listaApellidos.push(miVariable);
    let lista = this.listaApellidos;
    for (let i = 0; i < lista.length; i++) {
      const element = lista[i];
      console.log(element);
    }
  }

  public inicializarComponente(): Array<string> {
    let retorno: any;
    let objeto = undefined;
    if (objeto !== null && objeto !== undefined) {
      console.log('No es nulo');
    } else {
      console.log('Si es nulo');
    }

    console.log(1 == 1);
    //console.log("1" == 1);
    console.log(1 === 1);
    //console.log("1" === 1);
    this.comicDTO = new ComicDTO();
    this.comicDTO.autores = 'Pablito';
    this.comicDTO.fechaVenta = new Date();
    console.log(this.comicDTO.autores);
    return retorno;
  }
}
