import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageWasherComponent } from './manage-washer.component';

describe('ManageWasherComponent', () => {
  let component: ManageWasherComponent;
  let fixture: ComponentFixture<ManageWasherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageWasherComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageWasherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
