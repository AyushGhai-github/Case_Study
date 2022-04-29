import { TestBed } from '@angular/core/testing';

import { AddWasherService } from './add-washer.service';

describe('AddWasherService', () => {
  let service: AddWasherService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddWasherService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
