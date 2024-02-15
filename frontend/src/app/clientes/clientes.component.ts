import { Component, ViewChild } from '@angular/core';
import ClienteService from '../services/ClienteService';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { NewClientDialogComponent } from '../dialogs/new-client-dialog/new-client-dialog.component';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, CommonModule,NewClientDialogComponent],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css'
})
export class ClientesComponent {
  displayedColumns: string[] = ["id","nome","email","telefone","dt_criacao","is_deleted"]
  dataSource = new MatTableDataSource<any>([]);
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private cService: ClienteService,
    public dialog: MatDialog) {}
  
  
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
      this.getClientes();
  }

  getClientes() {
    this.cService.getClientes()
    .subscribe(res => {
      this.dataSource.data = res;
    })
  }

  openDialog(cliente = null): void {
    const dialogRef = this.dialog.open(NewClientDialogComponent, {
      data: { cliente: cliente != null ? cliente : null},
      width: '100vw',
      height: '50%',
      backdropClass: 'test',
      panelClass: 'bg-white'
    })

    dialogRef.afterClosed().subscribe(_ => {
      this.getClientes();
    })
  }

  Editar(cliente: any) {
    this.openDialog(cliente)
  }
}
