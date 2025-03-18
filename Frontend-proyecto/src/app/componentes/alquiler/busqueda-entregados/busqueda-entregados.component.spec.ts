import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusquedaEntregadosComponent } from './busqueda-entregados.component';

describe('BusquedaEntregadosComponent', () => {
  let component: BusquedaEntregadosComponent;
  let fixture: ComponentFixture<BusquedaEntregadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BusquedaEntregadosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BusquedaEntregadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
