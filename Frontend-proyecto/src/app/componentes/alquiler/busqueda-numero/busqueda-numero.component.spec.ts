import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusquedaNumeroComponent } from './busqueda-numero.component';

describe('BusquedaNumeroComponent', () => {
  let component: BusquedaNumeroComponent;
  let fixture: ComponentFixture<BusquedaNumeroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BusquedaNumeroComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BusquedaNumeroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
