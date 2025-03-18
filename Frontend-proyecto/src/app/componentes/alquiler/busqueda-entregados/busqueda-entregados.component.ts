import { Component, OnInit } from '@angular/core';
import { Alquiler } from '../../../entidades/alquiler/alquiler';
import { CommonModule } from '@angular/common';
import { AlquilerService } from '../../../servicios/alquiler/alquiler.service';

@Component({
  selector: 'app-busqueda-entregados',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './busqueda-entregados.component.html',
  styleUrl: './busqueda-entregados.component.css'
})
export class BusquedaEntregadosComponent implements OnInit {

  alquileresEntregados :Alquiler[];
  
  constructor(private alquilerServicio:AlquilerService) { }

  ngOnInit(): void {
    this.buscaralquileresEntregados();
  };


  buscaralquileresEntregados(){
    this.alquilerServicio.obtenerAlquileresEntregados().subscribe(
      (alquileres)=>{
        if(alquileres.length == 0){
          alert("No hay alquileres entregados");
        }
        this.alquileresEntregados = alquileres;
      });
  };

}
