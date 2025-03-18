import { Injectable } from '@angular/core';
import { Alquiler } from '../../entidades/alquiler/alquiler';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BorraralquilerService {
  
  private url: "http//localhost:8080/Alquiler";

  constructor(private httpClient: HttpClient) { }


  
  deleteAlquiler(alquiler:Alquiler):Observable<boolean>{
      return this.httpClient.delete<boolean>(`${this.url}/borraralquiler`, { body: alquiler });
    }
}
