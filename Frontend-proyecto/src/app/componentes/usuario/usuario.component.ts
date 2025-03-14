import { Component } from '@angular/core';
import { Usuario } from '../../entidades/usuario/usuario';

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

  constructor(private usuarioService: UsuarioService) {}

  registrar() {
    this.usuarioService.registrarUsuario(this.usuario).subscribe(
      (respuesta) => {
        this.mensaje = 'Usuario registrado exitosamente.';
      },
      (error) => {
        this.mensaje = 'Error al registrar usuario.';
      }
    );

}
