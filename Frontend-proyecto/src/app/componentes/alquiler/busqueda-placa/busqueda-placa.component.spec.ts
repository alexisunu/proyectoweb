import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusquedaPlacaComponent } from './busqueda-placa.component';

describe('BusquedaPlacaComponent', () => {
  let component: BusquedaPlacaComponent;
  let fixture: ComponentFixture<BusquedaPlacaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BusquedaPlacaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BusquedaPlacaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
