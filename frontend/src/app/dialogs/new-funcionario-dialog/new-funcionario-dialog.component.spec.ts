import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewFuncionarioDialogComponent } from './new-funcionario-dialog.component';

describe('NewFuncionarioDialogComponent', () => {
  let component: NewFuncionarioDialogComponent;
  let fixture: ComponentFixture<NewFuncionarioDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewFuncionarioDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewFuncionarioDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
