import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaderListComponent } from './leader-list.component';

describe('LeaderListComponent', () => {
  let component: LeaderListComponent;
  let fixture: ComponentFixture<LeaderListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaderListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaderListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
