import { TestBed } from '@angular/core/testing';

import { ManageWasherService } from './manage-washer.service';

describe('ManageWasherService', () => {
  let service: ManageWasherService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManageWasherService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
