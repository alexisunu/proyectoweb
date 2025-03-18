import { Component, OnInit } from '@angular/core';
import { NavAdminComponent } from "../../nav/nav-admin/nav-admin.component";
import { NavInicioComponent } from '../../nav/nav-inicio/nav-inicio.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Alquiler } from '../../../entidades/alquiler/alquiler';
import { AlquilerService } from '../../../servicios/alquiler/alquiler.service';

@Component({
  selector: 'app-busqueda-placa',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './busqueda-placa.component.html',
  styleUrl: './busqueda-placa.component.css'
})
export class BusquedaPlacaComponent implements OnInit {
  placa: string;
  alquiler : Alquiler = new Alquiler();

  mostrarTabla:boolean = false;
  rentalFound: any;
  

  constructor(private alquilerService:AlquilerService) { }
  
  ngOnInit(): void {
  }

  buscarAlquiler(){
    console.log(this.placa);

    this.alquilerService.getAlquilerEntregar(this.placa).subscribe(
      data => {
        if(data == null){
          this.rentalFound = false;
          this.placa = '';
        }else{
          this.rentalFound = true;
          this.alquiler = data;
          this.mostrarTabla = true;
          console.log(this.alquiler);
        }
        
      
      }
    )
    
  }


  cambiarEstado(){
    this.alquilerService.setestadoAlquiler(this.alquiler).subscribe(
      data => {
        if(data){
          alert("Estado cambiado");
          window.location.reload();
        }else{
          alert("Error al cambiar el estado");
        }
      });
  };

}
