import { TestBed } from '@angular/core/testing';

import { BorraralquilerService } from './borraralquiler.service';

describe('BorraralquilerService', () => {
  let service: BorraralquilerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BorraralquilerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
