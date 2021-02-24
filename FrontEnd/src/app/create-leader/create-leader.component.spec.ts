import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLeaderComponent } from './create-leader.component';

describe('CreateLeaderComponent', () => {
  let component: CreateLeaderComponent;
  let fixture: ComponentFixture<CreateLeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateLeaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateLeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
