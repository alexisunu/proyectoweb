import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginadminComponent } from "./componentes/loginadmin/loginadmin.component";
import { AdministradorComponent } from './componentes/administrador/administrador.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,AdministradorComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Frontend-proyecto';
}
