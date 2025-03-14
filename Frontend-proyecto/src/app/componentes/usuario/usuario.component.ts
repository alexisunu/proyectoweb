import { Component } from '@angular/core';
import { Usuario } from '../../entidades/usuario/usuario';
import { UsuarioService } from '../../servicios/usuario/usuario.service';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class UsuarioComponent {
  usuario: Usuario = new Usuario();
  mensaje: string = '';

  constructor(private usuarioService:UsuarioService) {}

 
}