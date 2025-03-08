import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavUsusarioComponent } from './nav-ususario.component';

describe('NavUsusarioComponent', () => {
  let component: NavUsusarioComponent;
  let fixture: ComponentFixture<NavUsusarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NavUsusarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NavUsusarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
