import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../../entidades/usuario/usuario';

@Injectable({
  providedIn: 'root'
})
export class LoginUsuarioService {
  bdURL= 'http://localhost:8080/usuario/login/loginU';

  constructor(private HttpClient: HttpClient) { }
  LoginUsuario(usuario: Usuario, password: string){
    return this.HttpClient.post(this.bdURL, {usuario, password});
  }
}
