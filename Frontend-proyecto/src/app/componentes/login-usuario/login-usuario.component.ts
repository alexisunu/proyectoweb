import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginUsuarioService } from '../../servicios/loginUsuario/login-usuario.service';
import { NavInicioComponent } from '../nav/nav-inicio/nav-inicio.component';
import { SessionserviceService } from '../../servicios/sessionservice/sessionservice.service';

@Component({
  selector: 'app-login-usuario',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login-usuario.component.html',
  styleUrls: ['./login-usuario.component.css'] // <-- con 's' al final y array
})

export class LoginUsuarioComponent implements OnInit {



  constructor(private sessionService: SessionserviceService, private router:Router, private fb: FormBuilder, private loginUsuarioServicio:LoginUsuarioService) { }

  nav: NavInicioComponent = new NavInicioComponent();
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
              this.nav.ocultar();
              // Redirigir al componente de administrador
              this.router.navigate(['/usuario']);
              this.sessionService.setUserId(formData.username);
              console.log(this.sessionService.getUserId())
  
  
          } else {
              console.log('Login incorrecto');
              alert('Inicio de sesión incorrecto');
              this.loginForm.reset();
          }
        });
      }
    }
}
