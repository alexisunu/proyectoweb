import { Component } from '@angular/core';
import { NavAdminComponent } from '../nav/nav-admin/nav-admin.component';
import { RouterOutlet } from '@angular/router';
import { NavegacionComponent } from "../navegacion/navegacion.component";

@Component({
  selector: 'app-administrador',
  standalone: true,
  imports: [RouterOutlet, NavegacionComponent],
  providers:[],
  templateUrl: './administrador.component.html',
  styleUrl: './administrador.component.css'
})
export class AdministradorComponent {
  
}
