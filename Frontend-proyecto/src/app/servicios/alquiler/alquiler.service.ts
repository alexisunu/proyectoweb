import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Alquiler } from '../../entidades/alquiler/alquiler';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {

  private url = "http://localhost:8080/Alquiler";

  constructor(private httpClient: HttpClient) { }

  getAlquilerEntregar(placa:string):Observable<Alquiler>{
    return this.httpClient.get<Alquiler>(`${this.url}/entregarVehiculo`, {params: {placa}});
  }

  setestadoAlquiler(alquiler:Alquiler):Observable<boolean>{
    return this.httpClient.post<boolean>(`${this.url}/cambiarEstado`, alquiler);
  }

  getAlquiler(id: number):Observable<Alquiler>{
    return this.httpClient.get<Alquiler>(`${this.url}/devolverVehiculo`, {params: {id}});
  }

  deleteAlquiler(alquiler:Alquiler):Observable<boolean>{
    return this.httpClient.delete<boolean>(`${this.url}/borraralquiler`, { body: alquiler });
  }
}
