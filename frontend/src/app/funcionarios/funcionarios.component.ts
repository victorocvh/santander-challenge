import { Component, ViewChild } from '@angular/core';
import FuncionarioService from '../services/FuncionarioService';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { NewClientDialogComponent } from '../dialogs/new-client-dialog/new-client-dialog.component';
import { NewFuncionarioDialogComponent } from '../dialogs/new-funcionario-dialog/new-funcionario-dialog.component';


@Component({
  selector: 'app-funcionarios',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, CommonModule,NewClientDialogComponent],
  templateUrl: './funcionarios.component.html',
  styleUrl: './funcionarios.component.css'
})
export class FuncionarioComponent {
  displayedColumns: string[] = ["id","nome","email","dt_contratacao","ativo","tipoFuncionario","No"]
  dataSource = new MatTableDataSource<any>([]);
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private fService: FuncionarioService,
    public dialog: MatDialog) {}
  
  
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
      this.getFuncionarios();
  }

  getFuncionarios() {
    this.fService.getFuncionarios()
    .subscribe(res => {
      this.dataSource.data = res;
    })
  }

  openDialog(funcionario = null): void {
    const dialogRef = this.dialog.open(NewFuncionarioDialogComponent, {
      data: { funcionario: funcionario != null ? funcionario : null},
      width: '100vw',
      height: '50%',
      backdropClass: 'test',
      panelClass: 'bg-white'
    })

    dialogRef.afterClosed().subscribe(_ => {
      this.getFuncionarios();
    })
  }

  Editar(funcionario: any) {
    this.openDialog(funcionario)
  }
}
