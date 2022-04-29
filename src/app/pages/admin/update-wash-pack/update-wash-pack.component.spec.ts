import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateWashPackComponent } from './update-wash-pack.component';

describe('UpdateWashPackComponent', () => {
  let component: UpdateWashPackComponent;
  let fixture: ComponentFixture<UpdateWashPackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateWashPackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateWashPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
