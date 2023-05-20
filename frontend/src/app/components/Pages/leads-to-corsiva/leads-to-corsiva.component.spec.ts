import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadsToCorsivaComponent } from './leads-to-corsiva.component';

describe('LeadsToCorsivaComponent', () => {
  let component: LeadsToCorsivaComponent;
  let fixture: ComponentFixture<LeadsToCorsivaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeadsToCorsivaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeadsToCorsivaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
