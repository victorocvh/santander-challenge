import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewProdDialogComponent } from './new-prod-dialog.component';

describe('NewProdDialogComponent', () => {
  let component: NewProdDialogComponent;
  let fixture: ComponentFixture<NewProdDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewProdDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewProdDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
