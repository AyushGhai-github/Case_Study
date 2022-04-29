import { TestBed } from '@angular/core/testing';

import { ViewLeaderboardService } from './view-leaderboard.service';

describe('ViewLeaderboardService', () => {
  let service: ViewLeaderboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewLeaderboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
