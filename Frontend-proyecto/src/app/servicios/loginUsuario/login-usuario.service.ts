import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginUsuarioService {
  bdURL= 'http://localhost:8080/usuario/login';

  constructor() { }
}
