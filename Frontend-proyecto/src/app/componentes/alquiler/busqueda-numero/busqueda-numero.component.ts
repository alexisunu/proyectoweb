import { Component, OnInit } from '@angular/core';
import { NavAdminComponent } from "../../nav/nav-admin/nav-admin.component";
import { NavInicioComponent } from '../../nav/nav-inicio/nav-inicio.component';

@Component({
  selector: 'app-busqueda-numero',
  standalone: true,
  imports: [NavAdminComponent],
  providers:[NavInicioComponent],
  templateUrl: './busqueda-numero.component.html',
  styleUrl: './busqueda-numero.component.css'
})
export class BusquedaNumeroComponent implements OnInit {
  nav:NavInicioComponent = new NavInicioComponent();
  constructor() { }

  ngOnInit(): void {
    this.nav.ocultar();
  }
}
