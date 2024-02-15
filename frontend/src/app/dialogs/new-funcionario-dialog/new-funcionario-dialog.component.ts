import { Component, Inject } from '@angular/core';
import Funcionario from '../../model/Funcionario';
import { MAT_DIALOG_DATA, MatDialog, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogTitle } from '@angular/material/dialog';
import FuncionarioService from '../../services/FuncionarioService';
import { DialogRef } from '@angular/cdk/dialog';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import TipoFuncionarioService from '../../services/TipoFuncionarioService';
import TipoFuncionario from '../../model/TipoFuncionario';

@Component({
  selector: 'app-new-funcionario-dialog',
  standalone: true,
  imports: [ MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose,
    MatInputModule,
    MatSelectModule],
  templateUrl: './new-funcionario-dialog.component.html',
  styleUrl: './new-funcionario-dialog.component.css'
})
export class NewFuncionarioDialogComponent {

  public funcionario = new Funcionario();
  public update = false;
  public tipoFuncionarioList: TipoFuncionario[] = [];
  
  constructor(public dialog: MatDialog,
    private fService: FuncionarioService,
    private tFService: TipoFuncionarioService,
    private dialogRef: DialogRef<NewFuncionarioDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  ngOnInit(): void {
      this.funcionario = this.data.funcionario || new Funcionario();
      this.update = this.data.funcionario ? true : false
      this.tFService.getTipoFuncionario().subscribe(res => {
        this.tipoFuncionarioList = res;
      })
  }

  SendData() {
    if (this.update) {
      this.fService.putFuncionario(this.funcionario).subscribe(res => {
        this.dialogRef.close();
      })
    } else {
      this.fService.postFuncionario(this.funcionario).subscribe(res => {
        this.dialogRef.close();
      })
    }
  }

}
