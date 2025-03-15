import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavUsusarioComponent } from '../../nav/nav-ususario/nav-ususario.component';
import { CommonModule } from '@angular/common';
import { Vehiculo } from '../../../entidades/vehiculo/vehiculo';
import { NavInicioComponent } from '../../nav/nav-inicio/nav-inicio.component';
import { VehiculoService } from '../../../servicios/vehiculo/vehiculo.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-buscar-tipo-usuario',
  standalone: true,
  templateUrl: './buscar-tipo-usuario.component.html',
  styleUrl: './buscar-tipo-usuario.component.css',
  imports: [NavUsusarioComponent,CommonModule,FormsModule]
})
export class BuscarTipoUsuarioComponent {

  tipoVehiculo: string;
  vehiculosDiponibles: Vehiculo [];
  nav:NavInicioComponent = new NavInicioComponent();
  constructor(private vehiculiServicio:VehiculoService) { }

  ngOnInit(): void {
    this.nav.ocultar();
  }

  public buscarVehiculosDisponibles(){
    this.vehiculiServicio.getVehiculosDisponibles(this.tipoVehiculo).subscribe(
      (vehiculos) => {
        this.vehiculosDiponibles = vehiculos;
      }
    );
  }

}
