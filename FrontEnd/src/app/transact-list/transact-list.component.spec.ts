import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactListComponent } from './transact-list.component';

describe('TransactListComponent', () => {
  let component: TransactListComponent;
  let fixture: ComponentFixture<TransactListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
