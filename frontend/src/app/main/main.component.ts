import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import VendasService from '../services/VendasService';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { NewVendaDialogComponent } from '../dialogs/new-venda-dialog/new-venda-dialog.component';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, CommonModule,NewVendaDialogComponent],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ["nomeCliente","nomeFuncionario","tipoFuncionario","nomeProduto","valorTotal","quantidade","dataVenda"]
  dataSource = new MatTableDataSource<any>([]);
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private vendasService: VendasService,
    private dialog: MatDialog) {}
  
  
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
      this.getVendas();
  }

  getVendas() {
    this.vendasService.getVendas()
    .subscribe(res => {
      this.dataSource.data = res;
    })
  }

  openDialog(venda = null): void {
    const dialogRef = this.dialog.open(NewVendaDialogComponent, {
      data: { venda: venda != null ? venda : null},
      width: '100vw',
      height: '50%',
      backdropClass: 'test',
      panelClass: 'bg-white'
    })

    dialogRef.afterClosed().subscribe(res => {
      alert('iuha')
    })
  }


}
