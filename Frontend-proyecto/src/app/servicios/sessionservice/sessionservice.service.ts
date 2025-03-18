import { isPlatformBrowser } from '@angular/common';
import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SessionserviceService {
  private userRoleSource = new BehaviorSubject<string>('public');
  userRole$ = this.userRoleSource.asObservable();

  private userIdSource = new BehaviorSubject<number | null>(null);
  userId$ = this.userIdSource.asObservable();

  constructor(@Inject(PLATFORM_ID) private platformId: Object) {

    // Verifica que el código se ejecute en el navegador
    if (isPlatformBrowser(this.platformId)) {
      const storedRole = localStorage.getItem('userRole');
      const storedId = localStorage.getItem('userId');

      // Si existe un rol almacenado, lo usa; de lo contrario, mantiene "public"
      if (storedRole) {
        this.userRoleSource.next(storedRole);
      } else {
        this.userRoleSource.next('public');
      }
      
      if (storedId) {
        this.userIdSource.next(parseInt(storedId, 10));
      }
    }
  }

  // Método para establecer la sesión del usuario con un rol específico
  setUserSession(id: number, role: string): void {
    this.userIdSource.next(id);
    localStorage.setItem('userId', id.toString());

    this.userRoleSource.next(role);
    localStorage.setItem('userRole', role);
  }

  // Método para cerrar sesión y limpiar el almacenamiento
  logout(): void {
    this.userIdSource.next(null);
    localStorage.removeItem('userId');

    // Al cerrar sesión, volvemos a asignar el rol "public"
    this.userRoleSource.next('public');
    localStorage.removeItem('userRole');
  }

  // Método para obtener el rol actual
  getUserRole(): string {
    return this.userRoleSource.getValue();
  }

  // Método para obtener el ID del usuario actual
  getUserId(): number | null {
    return this.userIdSource.getValue();
  }

}
