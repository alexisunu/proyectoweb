import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SessionserviceService {

  private userIdSource = new BehaviorSubject<number | null>(null);
  userId$ = this.userIdSource.asObservable();


  setUserId(id: number): void {
    this.userIdSource.next(id);
    localStorage.setItem('userId', id.toString());
  }

  getUserId(): number | null {
    return this.userIdSource.getValue();
  }

  constructor() { }
}
