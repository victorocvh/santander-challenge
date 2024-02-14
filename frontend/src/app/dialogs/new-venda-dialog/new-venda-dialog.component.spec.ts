import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewVendaDialogComponent } from './new-venda-dialog.component';

describe('NewVendaDialogComponent', () => {
  let component: NewVendaDialogComponent;
  let fixture: ComponentFixture<NewVendaDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewVendaDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewVendaDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
