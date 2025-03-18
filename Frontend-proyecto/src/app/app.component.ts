import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { LoginadminComponent } from "./componentes/loginadmin/loginadmin.component";
import { NavegacionComponent } from "./componentes/navegacion/navegacion.component";
import { SessionserviceService } from './servicios/sessionservice/sessionservice.service';
import { InicioComponent } from "./componentes/inicio/inicio.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavegacionComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {


  constructor(private router:Router, private sessionService: SessionserviceService) { }
  
  ngOnInit(): void {
    console.log(this.sessionService.getUserRole());
  }
  title = 'Frontend-proyecto';
}
