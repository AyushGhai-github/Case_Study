import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashPackComponent } from './wash-pack.component';

describe('WashPackComponent', () => {
  let component: WashPackComponent;
  let fixture: ComponentFixture<WashPackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashPackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WashPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
