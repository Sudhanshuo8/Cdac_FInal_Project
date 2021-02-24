import { TestBed } from '@angular/core/testing';

import { GatService } from './gat.service';

describe('GatService', () => {
  let service: GatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
