import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginadminComponent } from "./componentes/loginadmin/loginadmin.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginadminComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Frontend-proyecto';
}
