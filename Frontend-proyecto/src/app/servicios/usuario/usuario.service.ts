import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private apiUrl = 'http://localhost:8080/login'; 

  constructor(private http: HttpClient) {}

  login(usuario: string, password: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.apiUrl}/loginU`, { usuario, password });
  }

  registrarUsuario(datos: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/registro`, datos);
  }
}
