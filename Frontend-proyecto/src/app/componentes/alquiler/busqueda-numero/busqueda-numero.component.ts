import { Component, OnInit } from '@angular/core';
import { NavAdminComponent } from "../../nav/nav-admin/nav-admin.component";
import { NavInicioComponent } from '../../nav/nav-inicio/nav-inicio.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Alquiler } from '../../../entidades/alquiler/alquiler';
import { AlquilerService } from '../../../servicios/alquiler/alquiler.service';

@Component({
  selector: 'app-busqueda-numero',
  standalone: true,
  imports: [NavAdminComponent,CommonModule,FormsModule],
  providers:[NavInicioComponent],
  templateUrl: './busqueda-numero.component.html',
  styleUrl: './busqueda-numero.component.css'
})
export class BusquedaNumeroComponent implements OnInit {


  nav:NavInicioComponent = new NavInicioComponent();
  alquiler: Alquiler= new Alquiler();
  diasAdicionales: number;
  numero: number;
  total:number;

  constructor(private AlquilerSerivicio: AlquilerService) { }

  ngOnInit(): void {
    this.nav.ocultar();
  }

  BuscarAlquiler() {
    console.log(this.numero);
    this.AlquilerSerivicio.getAlquiler(this.numero).subscribe(
      (result) => {
        if(result != null){
        this.alquiler = result.alquiler;
        this.diasAdicionales = result.diasadicionales;
        this.total = this.diasAdicionales + this.alquiler.valorAlquiler;

        }else{
          alert("No se encontro el alquiler");
        }
        
      });
  }

  devolverVehiculo() {
    console.log(this.alquiler); 
    this.AlquilerSerivicio.deleteAlquiler(this.alquiler).subscribe((resultado)=>{
      if (resultado == true){
        alert("completado, El vehiculo vuelve a estar disponible");
        window.location.reload();
      }
      else{
        alert("devolucion no complpetada");
      }
    })
  }


}
