import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LatestBrochureComponent } from './latest-brochure.component';

describe('LatestBrochureComponent', () => {
  let component: LatestBrochureComponent;
  let fixture: ComponentFixture<LatestBrochureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LatestBrochureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LatestBrochureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
