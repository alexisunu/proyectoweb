import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../../entidades/usuario/usuario';

@Injectable({
  providedIn: 'root'
})
export class LoginUsuarioService {
  bdURL= 'http://localhost:8080/login/loginU';

  constructor(private HttpClient: HttpClient) { }
  LoginUsuario(usuario: String, password: string){
    return this.HttpClient.post(this.bdURL, {usuario, password});
  }
}
