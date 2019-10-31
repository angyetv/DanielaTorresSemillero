import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mis-datos-personales',
  templateUrl: './mis-datos-personales.component.html',
  styleUrls: ['./mis-datos-personales.component.css']
})
export class MisDatosPersonalesComponent implements OnInit {

  nombre = 'Angye Daniela Torres Veloza';
  ciudad = 'Tunja';
  urlGitHub = 'https://github.com/angyetv/DanielaTorresSemillero.git';
  constructor() { }

  ngOnInit() {
  }

}
