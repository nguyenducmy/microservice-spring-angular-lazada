import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadsFromCorsivaComponent } from './leads-from-corsiva.component';

describe('LeadsFromCorsivaComponent', () => {
  let component: LeadsFromCorsivaComponent;
  let fixture: ComponentFixture<LeadsFromCorsivaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeadsFromCorsivaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeadsFromCorsivaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
