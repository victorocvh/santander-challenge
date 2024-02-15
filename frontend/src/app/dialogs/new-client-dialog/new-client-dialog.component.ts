import { Component, Inject } from '@angular/core';
import ClienteService from '../../services/ClienteService';
import { MAT_DIALOG_DATA, MatDialog, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogModule, MatDialogTitle } from '@angular/material/dialog';
import { DialogRef } from '@angular/cdk/dialog';
import Funcionario from '../../model/Funcionario';
import Produto from '../../model/Produto';
import Cliente from '../../model/Cliente';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-new-client-dialog',
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
  templateUrl: './new-client-dialog.component.html',
  styleUrl: './new-client-dialog.component.css'
})
export class NewClientDialogComponent {

  public cliente = new Cliente();
  public update = false;
  public funcionarioId = 0;
  public funcionarioList : Funcionario[] = [];

  constructor(public dialog: MatDialog,
    private cService: ClienteService,
    private dialogRef: DialogRef<NewClientDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  ngOnInit(): void {
      this.cliente = this.data.cliente || new Cliente();
      this.update = this.data.cliente ? true : false
  }

  SendData() {
    if (this.update) {
      this.cService.putCliente(this.cliente).subscribe(res => {
        this.dialogRef.close();
      })
    } else {
      this.cService.postCliente(this.cliente).subscribe(res => {
        this.dialogRef.close();
      })
    }
  }

}
