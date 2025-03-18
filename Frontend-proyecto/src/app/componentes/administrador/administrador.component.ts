import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavegacionComponent } from "../navegacion/navegacion.component";

@Component({
  selector: 'app-administrador',
  standalone: true,
  imports: [RouterOutlet],
  providers:[],
  templateUrl: './administrador.component.html',
  styleUrl: './administrador.component.css'
})
export class AdministradorComponent {
  
}
