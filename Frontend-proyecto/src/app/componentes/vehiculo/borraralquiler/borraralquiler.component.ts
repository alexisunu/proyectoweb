import { Component, OnInit } from '@angular/core';
import { Alquiler } from '../../../entidades/alquiler/alquiler';
import { AlquilerService } from '../../../servicios/alquiler/alquiler.service';
import { CommonModule } from '@angular/common';
import { SessionserviceService } from '../../../servicios/sessionservice/sessionservice.service';

  @Component({
    selector: 'app-borraralquiler',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './borraralquiler.component.html',
    styleUrl: './borraralquiler.component.css'
  })
  export class BorraralquilerComponent implements OnInit {
    alquileres: Alquiler[] = [];
  
    constructor(private sessionservice:SessionserviceService ,private alquilerService: AlquilerService) { }
  
    ngOnInit(): void {
      this.obtenerAlquileres();
    }
  
    obtenerAlquileres(): void {
      const identificacion = this.sessionservice.getUserId();
      if (identificacion !== null) {
        this.alquilerService.obtenerAlquileres(Number(identificacion)).subscribe(
        (data) => this.alquileres = data,
        );
      }
    }
  
    borrarAlquiler(idAlquiler: number): void {
      if (confirm(`¿Estás seguro de que deseas eliminar el alquiler con ID ${idAlquiler}?`)) {
        const alquilerToDelete = this.alquileres.find(a => a.idAlquiler === idAlquiler);
        if (alquilerToDelete) {
          this.alquilerService.deleteAlquiler(alquilerToDelete).subscribe(
          (resultado) => {
            if (resultado) {
              this.alquileres = this.alquileres.filter(a => a.idAlquiler !== idAlquiler);
              alert('Alquiler eliminado correctamente.');
            } else {
              alert('No se pudo eliminar el alquiler.');
            }
          },
          (error) => console.error('Error al eliminar el alquiler', error)
        );
      }
    }
  }
} 
