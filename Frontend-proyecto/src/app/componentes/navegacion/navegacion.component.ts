import { Component, OnInit } from '@angular/core';
import { SessionserviceService } from '../../servicios/sessionservice/sessionservice.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navegacion',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './navegacion.component.html',
  styleUrl: './navegacion.component.css'
})
export class NavegacionComponent implements OnInit {

  role: string | null = null;

  constructor(private sessionService:SessionserviceService) { }

  ngOnInit(): void {
    this.sessionService.userRole$.subscribe(role => {
      this.role = role;
    })
  }

  cerrarSesion(){
    this.sessionService.logout();
    console.log(this.sessionService.getUserId());
  }
}
