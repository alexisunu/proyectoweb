import { Component } from '@angular/core';
import { NavAdminComponent } from '../nav/nav-admin/nav-admin.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-administrador',
  standalone: true,
  imports: [RouterOutlet,NavAdminComponent],
  providers:[],
  templateUrl: './administrador.component.html',
  styleUrl: './administrador.component.css'
})
export class AdministradorComponent {
  
}
