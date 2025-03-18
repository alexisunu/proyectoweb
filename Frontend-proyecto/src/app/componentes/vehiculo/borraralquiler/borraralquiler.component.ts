  import { Component, OnInit } from '@angular/core';
  import { NavAdminComponent } from "../../nav/nav-admin/nav-admin.component";
import { Alquiler } from '../../../entidades/alquiler/alquiler';
import { AlquilerService } from '../../../servicios/alquiler/alquiler.service';

  @Component({
    selector: 'app-borraralquiler',
    standalone: true,
    imports: [NavAdminComponent, CommonModule],
    templateUrl: './borraralquiler.component.html',
    styleUrl: './borraralquiler.component.css'
  })
  export class BorraralquilerComponent implements OnInit {
    alquileres: Alquiler[] = [];
  
    constructor(private alquilerService: AlquilerService) { }
  
    ngOnInit(): void {
      this.obtenerAlquileres();
    }
  
    obtenerAlquileres(): void {
      this.alquilerService.getAlquiler().subscribe(
        (data) => this.alquileres = data,
        (error) => console.error('Error al obtener los alquileres', error)
      );
    }
  
    borrarAlquiler(idAlquiler: number): void {
      if (confirm(`¿Estás seguro de que deseas eliminar el alquiler con ID ${idAlquiler}?`)) {
        this.alquilerService.deleteAlquiler(idAlquiler).subscribe(
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
  
