import { TestBed } from '@angular/core/testing';

import { WashPackService } from './wash-pack.service';

describe('WashPackService', () => {
  let service: WashPackService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WashPackService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
