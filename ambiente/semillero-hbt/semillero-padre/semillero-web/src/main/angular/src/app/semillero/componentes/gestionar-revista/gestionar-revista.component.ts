import { Component, OnInit } from '@angular/core';
import { RevistaDTO } from '../../dto/revista.dto';

@Component({
  selector: 'app-gestionar-revista',
  templateUrl: './gestionar-revista.component.html',
  styleUrls: ['./gestionar-revista.component.css']
})
export class GestionarRevistaComponent implements OnInit {

  public listaRevistas: Array<RevistaDTO>;
  public revistaBorrada: string;
  public mostrarDetalles: boolean;
  public precioMayor: number;
  public listaFiltradaPorPrecio: Array<RevistaDTO>;
  public fillColor: string;

  constructor() { }

  ngOnInit() {
    this.listaRevistas = new Array<RevistaDTO>();
    let batman: RevistaDTO = {
      id: 1,
      nombre: 'Batman',
      editorial: 'Marvel',
      tematica: 'Acción',
      numeroPaginas: 50,
      precio: 80500.99,
      autores: 'Pedrito Barrera',
      aColor: true,
      fechaVenta: new Date('10-10-2019'),
      estado: 'Activo'
    };
    this.listaRevistas.push(batman);

    let spiderMan: RevistaDTO = {
      id: 2,
      nombre: 'Spider Man',
      editorial: 'Marvel',
      tematica: 'Acción',
      numeroPaginas: 128,
      precio: 60900.99,
      autores: 'James Towe, Matt Horak, Robbie Thompson',
      aColor: true,
      fechaVenta: new Date('10-17-2019'),
      estado: 'Activo'
    };
    this.listaRevistas.push(spiderMan);

    let capitanAmerica: RevistaDTO = {
      id: 3,
      nombre: 'Capitán América',
      editorial: 'Marvel',
      tematica: 'Acción',
      numeroPaginas: 56,
      precio: 50301.99,
      autores: 'Frank Miller',
      aColor: true,
      fechaVenta: new Date('10-3-2019'),
      estado: 'Activo'
    };
    this.listaRevistas.push(capitanAmerica);

    let vengadores: RevistaDTO = {
      id: 4,
      nombre: 'Vengadores',
      editorial: 'Marvel',
      tematica: 'Acción',
      numeroPaginas: 48,
      precio: 42900.99,
      autores: 'Ed McGuinness, Jason Aaron ',
      aColor: true,
      fechaVenta: new Date('10-3-2019'),
      estado: 'Activo'
    };
    this.listaRevistas.push(vengadores);

    let hulk: RevistaDTO = {
      id: 5,
      nombre: 'Hulk',
      editorial: 'Marvel',
      tematica: 'Acción',
      numeroPaginas: 24,
      precio: 30700.99,
      autores: 'Al Ewing, Joe Bennett',
      aColor: true,
      fechaVenta: new Date('10-3-2019'),
      estado: 'Activo'
    };
    this.listaRevistas.push(hulk);
    console.log(JSON.stringify(this.listaRevistas));
    this.mostrarDetalles = false;
    this.precioMayor = 60000;
    this.fillColor = 'rgb(255, 0, 0)';
  }

  borrarDeLaLista(posicionABorrar: number): void {
    if (this.listaRevistas.length > posicionABorrar) {
      this.revistaBorrada = 'Ha borrado la revista ' + this.listaRevistas[posicionABorrar].nombre;
      console.log(this.listaRevistas[posicionABorrar].nombre);
      this.listaRevistas.splice(posicionABorrar, 1);
      console.log('Lista borrada', JSON.stringify(this.listaRevistas));
    } else {
      this.revistaBorrada = 'Error, no se encuentra la posicion para borrar.';
    }
  }

  cambiarMostrarDetalles(): void {
    this.mostrarDetalles = !this.mostrarDetalles;
  }

  filtrarPorPrecio(): void {
    this.listaFiltradaPorPrecio = new Array<RevistaDTO>();
    this.listaRevistas.forEach(element => {
      if (element.precio < this.precioMayor) {
        this.listaFiltradaPorPrecio.push(element);
      }
    });
  }

  changeColor() {
    const r = Math.floor(Math.random() * 256);
    const g = Math.floor(Math.random() * 256);
    const b = Math.floor(Math.random() * 256);
    this.fillColor = `rgb(${r}, ${g}, ${b})`;
  }
}
