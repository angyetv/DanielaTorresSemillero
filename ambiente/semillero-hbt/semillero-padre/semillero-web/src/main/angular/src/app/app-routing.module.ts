import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ConsultarComicComponent } from './semillero/componentes/consultar-comic/consultar-comic.component';
import { GestionarUsuariosComponent } from './semillero/componentes/gestionar-usuarios/gestionar-usuarios.component';
import { ConsultarUsuarioComponent } from './semillero/componentes/consultar-usuario/consultar-usuario.component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent },
  { path: 'consultar-comic', component: ConsultarComicComponent, data: null },
  { path: 'gestionar-usuarios', component: GestionarUsuariosComponent },
  { path: 'consultar-usuario', component: ConsultarUsuarioComponent, data: null }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
