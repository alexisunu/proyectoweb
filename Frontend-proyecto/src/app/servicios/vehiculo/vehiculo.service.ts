import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehiculo } from '../../entidades/vehiculo/vehiculo';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {

  private url = 'http://localhost:8080/vehiculos';

  constructor(private httpClient:HttpClient) { }

  getVehiculosDisponibles(tipo:String): Observable<Vehiculo[]>{
    return this.httpClient.post<Vehiculo[]>(`${this.url}/listaDisponibles`, { tipo });
  }
}
