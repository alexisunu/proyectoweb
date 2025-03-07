import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { LoginadminService } from '../../servicios/loginadmin/loginadmin.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-loginadmin',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './loginadmin.component.html',
  styleUrl: './loginadmin.component.css'
})
export class LoginadminComponent implements OnInit {
  loginForm: FormGroup;
  constructor(private fb: FormBuilder,private loginadminServicio: LoginadminService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  public comprobarLoginadmin(){
    if (this.loginForm.valid) {
      const formData = this.loginForm.value;
      console.log(formData);
      this.loginadminServicio.getLoginAdmin(formData.username, formData.password)
      .subscribe((res) => {
        console.log(res);
      });
    }
  }
}
