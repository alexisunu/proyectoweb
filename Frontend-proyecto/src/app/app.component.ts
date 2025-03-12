import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginadminComponent } from "./componentes/loginadmin/loginadmin.component";
import { AdministradorComponent } from './componentes/administrador/administrador.component';
import { NavInicioComponent } from './componentes/nav/nav-inicio/nav-inicio.component';
import { NavAdminComponent } from "./componentes/nav/nav-admin/nav-admin.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavInicioComponent, AdministradorComponent],
  providers: [LoginadminComponent, NavAdminComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  
  ngOnInit(): void {

    
  }
  title = 'Frontend-proyecto';

  
}
