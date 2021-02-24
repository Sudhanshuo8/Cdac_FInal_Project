import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TranssactionAddComponent } from './transsaction-add.component';

describe('TranssactionAddComponent', () => {
  let component: TranssactionAddComponent;
  let fixture: ComponentFixture<TranssactionAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TranssactionAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TranssactionAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
