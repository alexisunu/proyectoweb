import { Component } from '@angular/core';
import { format } from 'date-fns';
import { NavUsusarioComponent } from '../../nav/nav-ususario/nav-ususario.component';
import { CommonModule } from '@angular/common';
import { Vehiculo } from '../../../entidades/vehiculo/vehiculo';
import { NavInicioComponent } from '../../nav/nav-inicio/nav-inicio.component';
import { VehiculoService } from '../../../servicios/vehiculo/vehiculo.service';
import { FormsModule } from '@angular/forms';
import { SessionserviceService } from '../../../servicios/sessionservice/sessionservice.service';
import { AlquilerService } from '../../../servicios/alquiler/alquiler.service';
import { Alquiler } from '../../../entidades/alquiler/alquiler';

@Component({
  selector: 'app-buscar-tipo-usuario',
  standalone: true,
  templateUrl: './buscar-tipo-usuario.component.html',
  styleUrl: './buscar-tipo-usuario.component.css',
  imports: [NavUsusarioComponent, CommonModule, FormsModule]
})
export class BuscarTipoUsuarioComponent {

  today: String;
  tipoVehiculo: string;
  vehiculosDiponibles: Vehiculo[] = [];
  alquiler: Alquiler = new Alquiler();
  nav: NavInicioComponent = new NavInicioComponent();
  startDate: string;
  endDate: string;
  placaVehiculo: string;

  // VARIABLES DE PAGINACIÓN
  currentPage: number = 1;
  itemsPerPage: number = 5;  // Cantidad de vehículos por página
  totalPages: number = 1;

  constructor(
    private vehiculiServicio: VehiculoService,
    private AlquilerService: AlquilerService
  ) {
    const todayDate = new Date();
    this.today = todayDate.toISOString().split('T')[0];
  }

  ngOnInit(): void {
    this.nav.ocultar();
  }

  public buscarVehiculosDisponibles() {
    this.vehiculiServicio.getVehiculosDisponibles(this.tipoVehiculo).subscribe(
      (vehiculos) => {
        this.vehiculosDiponibles = vehiculos;
        // Actualizamos paginación
        this.totalPages = Math.ceil(this.vehiculosDiponibles.length / this.itemsPerPage);
        this.currentPage = 1;
      }
    );
  }

  public Alquilar(placa: string) {
    this.placaVehiculo = placa;
    console.log(placa);
    console.log(localStorage.getItem('userId'));
  }

  realizarAlquiler() {
    const id = localStorage.getItem('userId');
    console.log(id)
    const formattedStartDate = this.formatDate(this.startDate);
    const formattedEndDate = this.formatDate(this.endDate);

    if (id) {
      this.AlquilerService.crearAlquiler(this.placaVehiculo, id, formattedStartDate, formattedEndDate).subscribe(
        (data) => {
          if (data != null) {
            this.alquiler = data;
            console.log(this.alquiler);
            console.log("Alquiler exitoso");
          } else {
            console.log("Surgió un problema");
          }
        }
      );
    } else {
      console.error('User ID is null');
    }
  }

  actualizarFechaMinima() {
    if (this.startDate) {
      this.endDate = this.startDate; // La fecha de entrega no puede ser anterior a la de inicio
    }
  }

  formatDate(date: string): string {
    if (!date) return '';
    return format(new Date(date), 'MM/dd/yy'); // Convierte a MM/dd/yy
  }

  // Métodos de paginación

  get startIndex() {
    return (this.currentPage - 1) * this.itemsPerPage;
  }

  get endIndex() {
    return this.startIndex + this.itemsPerPage;
  }

  nextPage() {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
    }
  }

  prevPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }
}
