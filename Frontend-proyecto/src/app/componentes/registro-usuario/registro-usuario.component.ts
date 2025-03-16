import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../servicios/usuario/usuario.service';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-registro-usuario',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './registro-usuario.component.html',
  styleUrl: './registro-usuario.component.css'
})
export class RegistroUsuarioComponent implements OnInit {

  registroForm: FormGroup;

  constructor(private router:Router, private fb: FormBuilder, private usuarioService:UsuarioService) {}

  ngOnInit(): void {
    this.registroForm = this.fb.group({
      Identificacion: ['', Validators.required],
      nombreCompleto: ['', Validators.required],
      fechaExpedicionLicencia: ['', Validators.required],
      categoriaLicencia: ['', Validators.required],
      vigenciaLicencia: ['', Validators.required],
      correo : ['', Validators.required],
      telefono: ['', Validators.required],
      password : ['', Validators.required]
    });
  }


  registrarUsuario(){
    if(this.registroForm.valid){
      const usuario = this.registroForm.value;
      this.usuarioService.registrarUsuario(
        usuario.Identificacion, 
        usuario.nombreCompleto,
        usuario.fechaExpedicionLicencia, 
        usuario.categoriaLicencia,
        usuario.vigenciaLicencia,
        usuario.correo, 
        usuario.telefono, 
        usuario.password
      ).subscribe({
        next: (data) => {
          if(data != null){
            console.log(data);
            // Redirecciona a la página de login
            this.router.navigate(['/loginusuario']);
          }
        },
        error: (error) => {
          console.error('Error en el registro: no se registra', error);
          // Aquí podrías manejar el error, mostrar un mensaje, etc.
        }
      });
    }
  }
  
    }
  