import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BorraralquilerComponent } from './borraralquiler.component';

describe('BorraralquilerComponent', () => {
  let component: BorraralquilerComponent;
  let fixture: ComponentFixture<BorraralquilerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BorraralquilerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BorraralquilerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
