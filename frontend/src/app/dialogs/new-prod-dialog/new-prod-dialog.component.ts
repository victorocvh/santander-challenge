import { Component, Inject, OnInit } from '@angular/core';
import {
  MatDialog,
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {FormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import Produto from '../../model/Produto';
import ProdutoService from '../../services/ProdutosService';
import { DialogRef } from '@angular/cdk/dialog';
import Funcionario from '../../model/Funcionario';
import FuncionarioService from '../../services/FuncionarioService';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-new-prod-dialog',
  standalone: true,
  imports: [    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose,
    MatInputModule,
    MatSelectModule],
  templateUrl: './new-prod-dialog.component.html',
  styleUrl: './new-prod-dialog.component.css'
})
export class NewProdDialogComponent implements OnInit {
  
  public produto = new Produto();
  public update = false;
  public funcionarioId = 0;
  public funcionarioList : Funcionario[] = [];

  constructor(public dialog: MatDialog,
    private pService: ProdutoService,
    private fService: FuncionarioService,
    private dialogRef: DialogRef<NewProdDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  ngOnInit(): void {
      this.produto = this.data.produto || new Produto();
      this.update = this.data.produto ? true : false
      this.fService.getFuncionarios().subscribe(res => {
        this.funcionarioList = res;
      })
  }

  SendData() {
    if (this.update) {
      this.pService.putProduto(this.produto, this.funcionarioId).subscribe(res => {
        this.dialogRef.close();
      })
    } else {
      this.pService.postProduto(this.produto, this.funcionarioId).subscribe(res => {
        this.dialogRef.close();
      })
    }
  }

}
