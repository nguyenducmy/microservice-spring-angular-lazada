import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignedRepoComponent } from './signed-repo.component';

describe('SignedRepoComponent', () => {
  let component: SignedRepoComponent;
  let fixture: ComponentFixture<SignedRepoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignedRepoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SignedRepoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
