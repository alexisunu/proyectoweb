import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../../entidades/usuario/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  apiUrl = 'http://localhost:8080/usuarios'; 

  constructor(private http: HttpClient) {}

  
  registrarUsuario(
    identificacion: number, 
    nombreCompleto: string, 
    fechaExpedicionLicencia: Date,
    categoriaLicencia: string, 
    vigenciaLicencia: string, 
    correo: string, 
    telefono: string, 
    password: string
  ): Observable<Usuario> {
    // Se arma el objeto usuario
    const usuario = {
      identificacion,
      nombreCompleto,
      fechaExpedicionLicencia,
      categoriaLicencia,
      vigenciaLicencia,
      correo,
      telefono
    };
    console.log(usuario);
  
    // Se configura el parámetro extra
    const params = new HttpParams().set('password', password);
  
    // Se envía el objeto en el body y el password en los parámetros
    return this.http.post<Usuario>(`${this.apiUrl}/guardarU`, usuario, { params });
  }
  
}
