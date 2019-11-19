import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

/**
 * @description Componente bienvenida, el cual contiene la imagen de bienvenida al semillero
 *
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
 */
@Component({
  selector: 'bienvenida',
  templateUrl: './bienvenida-component.html',
})
export class BienvenidaComponent implements OnInit {

  public urlImagen: string;

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
    console.log('entro al constructor del componente bienvenida');
  }

  ngOnInit(): void {
    this.urlImagen = 'https://www.elempleo.com/sitios-empresariales/colombia/heinsohn-business-technology/img/elempleo-02.jpg';
    let data = this.activatedRoute.snapshot.params;
  }

  public ejecucionEventoClick(parametroEvento: any, numero: number): void {
    alert('Hola: ' + parametroEvento + ' ' + numero);
  }
}
