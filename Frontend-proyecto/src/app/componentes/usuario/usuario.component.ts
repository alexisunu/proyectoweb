import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../entidades/usuario/usuario';
import { UsuarioService } from '../../servicios/usuario/usuario.service';
import { NavUsusarioComponent } from "../nav/nav-ususario/nav-ususario.component";
import { RouterOutlet } from '@angular/router';
import { NavegacionComponent } from "../navegacion/navegacion.component";
import { SessionserviceService } from '../../servicios/sessionservice/sessionservice.service';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class UsuarioComponent implements OnInit {
  usuario: Usuario = new Usuario();
  mensaje: string = '';

  constructor(private sessionService: SessionserviceService) {}
  ngOnInit(): void {
    console.log(this.sessionService.getUserRole());
  }

 
}