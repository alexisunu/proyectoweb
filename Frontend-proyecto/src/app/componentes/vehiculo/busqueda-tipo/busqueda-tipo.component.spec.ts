import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusquedaTipoComponent } from './busqueda-tipo.component';

describe('BusquedaTipoComponent', () => {
  let component: BusquedaTipoComponent;
  let fixture: ComponentFixture<BusquedaTipoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BusquedaTipoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BusquedaTipoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
