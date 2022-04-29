import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserWashPackComponent } from './user-wash-pack.component';

describe('UserWashPackComponent', () => {
  let component: UserWashPackComponent;
  let fixture: ComponentFixture<UserWashPackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserWashPackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserWashPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
