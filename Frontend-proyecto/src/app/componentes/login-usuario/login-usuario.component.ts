import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginUsuarioService } from '../../servicios/loginUsuario/login-usuario.service';

import { SessionserviceService } from '../../servicios/sessionservice/sessionservice.service';

@Component({
  selector: 'app-login-usuario',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login-usuario.component.html',
  styleUrls: ['./login-usuario.component.css'] // <-- con 's' al final y array
})

export class LoginUsuarioComponent implements OnInit {

  readonly roleuser = 'usuario';



  constructor(private sessionService: SessionserviceService, private router:Router, private fb: FormBuilder, private loginUsuarioServicio:LoginUsuarioService) { }

  loginForm: FormGroup;

    ngOnInit(): void {
      this.loginForm = this.fb.group({
        username: ['', Validators.required],
        password: ['', Validators.required]
      });
    }

    comprobarLoginusuario() {
      if (this.loginForm.valid) {
        const formData = this.loginForm.value;
        console.log(formData);
        this.loginUsuarioServicio.LoginUsuario(formData.username, formData.password)
        .subscribe((res) => {
          console.log(res);
          if (res) {
              console.log('Login correcto');
              // Guardar la sesión del usuario
              this.sessionService.setUserSession(formData.username, this.roleuser);
              console.log(this.sessionService.getUserId());
              console.log(this.sessionService.getUserRole());
              // Redirigir al componente de administrador
              this.router.navigate(['/vehiculoUsuario']);
              
  
  
          } else {
              console.log('Login incorrecto');
              alert('Inicio de sesión incorrecto');
              this.loginForm.reset();
          }
        });
      }
    }
}
