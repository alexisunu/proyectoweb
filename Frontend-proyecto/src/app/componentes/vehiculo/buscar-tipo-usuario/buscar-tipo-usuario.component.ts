import { Component } from '@angular/core';
import {format} from 'date-fns';
import { CommonModule } from '@angular/common';
import { Vehiculo } from '../../../entidades/vehiculo/vehiculo';
import { VehiculoService } from '../../../servicios/vehiculo/vehiculo.service';
import { FormsModule } from '@angular/forms';
import { SessionserviceService } from '../../../servicios/sessionservice/sessionservice.service';
import { AlquilerService } from '../../../servicios/alquiler/alquiler.service';
import { Alquiler } from '../../../entidades/alquiler/alquiler';
import { jsPDF } from 'jspdf';
import { NavegacionComponent } from "../../navegacion/navegacion.component";

@Component({
  selector: 'app-buscar-tipo-usuario',
  standalone: true,
  templateUrl: './buscar-tipo-usuario.component.html',
  styleUrl: './buscar-tipo-usuario.component.css',
  imports: [CommonModule, FormsModule]
})
export class BuscarTipoUsuarioComponent {

  today: string;
  tipoVehiculo: string;
  vehiculosDiponibles: Vehiculo[] = [];
  alquiler: Alquiler = new Alquiler();
  startDate: string;
  endDate: string;
  placaVehiculo: string;

  // ================= PAGINACIÓN =================
  currentPage: number = 1;
  itemsPerPage: number = 5;
  totalPages: number = 1;
  // ==============================================

  constructor(
    private session: SessionserviceService, 
    private vehiculiServicio: VehiculoService, 
    private AlquilerService: AlquilerService
  ) {
    const todayDate = new Date();
    this.today = todayDate.toISOString().split('T')[0];
  }

  ngOnInit(): void {
  }

  public buscarVehiculosDisponibles() {
    this.vehiculiServicio.getVehiculosDisponibles(this.tipoVehiculo).subscribe(
      (vehiculos) => {
        this.vehiculosDiponibles = vehiculos;
        this.totalPages = Math.ceil(this.vehiculosDiponibles.length / this.itemsPerPage);
        this.currentPage = 1;
      }
    );
  }

  // PAGINACIÓN
  get paginatedVehiculos() {
    const start = (this.currentPage - 1) * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    return this.vehiculosDiponibles.slice(start, end);
  }

  setPage(page: number) {
    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
    }
  }
  // FIN PAGINACIÓN

  public Alquilar(placa: string) {
    this.placaVehiculo = placa;
    console.log(placa);
    console.log(localStorage.getItem('userId'));
  }

  realizarAlquiler() {
    const id = localStorage.getItem('userId');
    const formattedStartDate = this.formatDate(this.startDate);
    const formattedEndDate = this.formatDate(this.endDate);

    if (id) {
      this.AlquilerService.crearAlquiler(this.placaVehiculo, id, formattedStartDate, formattedEndDate).subscribe(
        (data) => {
          if (data != null) {
            this.alquiler = data;
            console.log(this.alquiler);
            console.log("alquiler exitoso");
            this.generatePDF();
            window.location.reload();
          } else {
            console.log("surgió un problema");
          }
        }
      );
    } else {
      console.error('User ID is null');
    }
  }

  actualizarFechaMinima() {
    if (this.startDate) {
      this.endDate = this.startDate;
    }
  }

  formatDate(date: string): string {
    if (!date) return '';
    return format(new Date(date), 'MM/dd/yy');
  }

  generatePDF() {
    const doc = new jsPDF('p', 'mm', 'a4');
    let y = 15;

    doc.setFontSize(20);
    doc.setTextColor(0, 102, 204);
    const title = "Reporte de Alquiler MiCacharrito";
    const pageWidth = doc.internal.pageSize.getWidth();
    const textWidth = doc.getTextWidth(title);
    const x = (pageWidth - textWidth) / 2;
    doc.text(title, x, y);
    y += 10;
    doc.setLineWidth(0.5);
    doc.line(10, y, 200, y);
    y += 10;

    doc.setFontSize(16);
    doc.setTextColor(0, 102, 204);
    doc.text("Información del Alquiler", 10, y);
    y += 8;
    doc.setDrawColor(0, 102, 204);
    doc.line(10, y, 200, y);
    y += 8;

    doc.setFontSize(12);
    doc.setTextColor(0, 0, 0);
    doc.text(`ID Alquiler: ${this.alquiler.idAlquiler || 'N/A'}`, 10, y);
    y += 8;
    doc.text(`Fecha de Inicio: ${this.startDate}`, 10, y);
    y += 8;
    doc.text(`Fecha de Entrega: ${this.endDate}`, 10, y);
    y += 8;
    const valorAlquilerFormatted = new Intl.NumberFormat('es-CO', { style: 'currency', currency: 'COP' }).format(this.alquiler.valorAlquiler);
    doc.text(`Valor del alquiler: ${valorAlquilerFormatted}`, 10, y);
    y += 8;
    doc.text(`Estado del alquiler: ${this.alquiler.estado}`, 10, y);
    y += 15;

    doc.setFontSize(16);
    doc.setTextColor(0, 102, 204);
    doc.text("Información del Vehículo", 10, y);
    y += 8;
    doc.setDrawColor(0, 102, 204);
    doc.line(10, y, 200, y);
    y += 8;

    doc.setFontSize(12);
    doc.setTextColor(0, 0, 0);
    doc.text(`Placa del Vehículo: ${this.placaVehiculo}`, 10, y);
    y += 8;
    if (this.alquiler.idVehiculo) {
      doc.text(`Tipo: ${this.alquiler.idVehiculo.tipoDeVehiculo}`, 10, y);
      y += 8;
      doc.text(`Color: ${this.alquiler.idVehiculo.color}`, 10, y);
      y += 8;
    }
    y += 7;

    doc.setFontSize(16);
    doc.setTextColor(0, 102, 204);
    doc.text("Información del Usuario", 10, y);
    y += 8;
    doc.setDrawColor(0, 102, 204);
    doc.line(10, y, 200, y);
    y += 8;

    doc.setFontSize(12);
    doc.setTextColor(0, 0, 0);
    const userId = localStorage.getItem('userId');
    doc.text(`ID del usuario: ${userId || 'N/A'}`, 10, y);
    y += 8;
    doc.text(`Nombre: ${this.alquiler.identificacion.nombreCompleto}`, 10, y);
    y += 8;
    doc.text(`Correo: ${this.alquiler.identificacion.correo}`, 10, y);
    y += 8;
    doc.text(`Teléfono: ${this.alquiler.identificacion.telefono}`, 10, y);
    y += 8;
    doc.text(`Fecha de expedición de la licencia: ${this.alquiler.identificacion.fechaExpedicionLicencia}`, 10, y);
    y += 15;

    doc.setFontSize(10);
    doc.text("Gracias por su confianza.", 10, 280);

    doc.save('alquiler.pdf');
  }

}

