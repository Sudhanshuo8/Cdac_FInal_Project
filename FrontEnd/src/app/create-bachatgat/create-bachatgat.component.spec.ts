import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBachatgatComponent } from './create-bachatgat.component';

describe('CreateBachatgatComponent', () => {
  let component: CreateBachatgatComponent;
  let fixture: ComponentFixture<CreateBachatgatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateBachatgatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBachatgatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
