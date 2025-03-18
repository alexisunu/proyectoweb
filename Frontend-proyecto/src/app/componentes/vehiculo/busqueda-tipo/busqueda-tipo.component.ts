import { Component, OnInit } from '@angular/core';
import { VehiculoService } from '../../../servicios/vehiculo/vehiculo.service';
import { Vehiculo } from '../../../entidades/vehiculo/vehiculo';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NavAdminComponent } from "../../nav/nav-admin/nav-admin.component";
import { NavInicioComponent } from '../../nav/nav-inicio/nav-inicio.component';

@Component({
  selector: 'app-busqueda-tipo',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './busqueda-tipo.component.html',
  styleUrl: './busqueda-tipo.component.css'
})
export class BusquedaTipoComponent implements OnInit {
  tipoVehiculo: string;
  vehiculosDiponibles: Vehiculo [];
  constructor(private vehiculiServicio:VehiculoService) { }

  ngOnInit(): void {
  }

  public buscarVehiculosDisponibles(){
    this.vehiculiServicio.getVehiculosDisponibles(this.tipoVehiculo).subscribe(
      (vehiculos) => {
        this.vehiculosDiponibles = vehiculos;
      }
    );
  }

}
