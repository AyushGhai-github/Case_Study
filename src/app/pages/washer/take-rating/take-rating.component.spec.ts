import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TakeRatingComponent } from './take-rating.component';

describe('TakeRatingComponent', () => {
  let component: TakeRatingComponent;
  let fixture: ComponentFixture<TakeRatingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TakeRatingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TakeRatingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
