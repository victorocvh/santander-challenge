import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewClientDialogComponent } from './new-client-dialog.component';

describe('NewClientDialogComponent', () => {
  let component: NewClientDialogComponent;
  let fixture: ComponentFixture<NewClientDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewClientDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewClientDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
