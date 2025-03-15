import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarTipoUsuarioComponent } from './buscar-tipo-usuario.component';

describe('BuscarTipoUsuarioComponent', () => {
  let component: BuscarTipoUsuarioComponent;
  let fixture: ComponentFixture<BuscarTipoUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuscarTipoUsuarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BuscarTipoUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
