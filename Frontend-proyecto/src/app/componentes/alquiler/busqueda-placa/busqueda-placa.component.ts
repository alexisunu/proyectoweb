import { Component, OnInit } from '@angular/core';
import { NavAdminComponent } from "../../nav/nav-admin/nav-admin.component";
import { NavInicioComponent } from '../../nav/nav-inicio/nav-inicio.component';

@Component({
  selector: 'app-busqueda-placa',
  standalone: true,
  imports: [NavAdminComponent],
  providers:[NavInicioComponent],
  templateUrl: './busqueda-placa.component.html',
  styleUrl: './busqueda-placa.component.css'
})
export class BusquedaPlacaComponent implements OnInit {
  nav:NavInicioComponent = new NavInicioComponent();
  
  ngOnInit(): void {
    this.nav.ocultar();
  }

}
