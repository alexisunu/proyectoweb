import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-nav-inicio',
  standalone: true,
  imports: [RouterOutlet,CommonModule],
  templateUrl: './nav-inicio.component.html',
  styleUrl: './nav-inicio.component.css'
})
export class NavInicioComponent implements OnInit{
  static ocultar() {
    throw new Error('Method not implemented.');
  }

  constructor() { }

  ngOnInit(): void {
  }
  
  ocultar(){
    const nav = document.getElementById('nav-inicio');
    nav!.style.display = "none"; 
  }

}
