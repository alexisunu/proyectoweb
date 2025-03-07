import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginadminService {

  bdURL= 'http://localhost:8080/administrador/login';

  constructor(private httpClient: HttpClient) { }

  getLoginAdmin(usuario: string, password: string){
    return this.httpClient.post(this.bdURL, {usuario, password});
  }
}
