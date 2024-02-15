import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import VendasService from '../services/VendasService';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { CommonModule } from '@angular/common';
import ProdutoService from '../services/ProdutosService';
import {
  MatDialog,
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';
import { NewProdDialogComponent } from '../dialogs/new-prod-dialog/new-prod-dialog.component';
import Produto from '../model/Produto';


@Component({
  selector: 'app-produtos',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, CommonModule, NewProdDialogComponent],
  templateUrl: './produtos.component.html',
  styleUrl: './produtos.component.css'
})
export class ProdutosComponent {
  displayedColumns: string[] = ["id","ativo","dt_atualizacao_preco","nome_produto","preco","no"]
  dataSource = new MatTableDataSource<any>([]);
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private produtosService: ProdutoService,
    public dialog: MatDialog) {}
  
  
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
      this.getProdutos();
  }

  getProdutos() {
    this.produtosService.getProdutos()
    .subscribe(res => {
      console.log('res: ', res)
      this.dataSource.data = res;
    })
  }

  openDialog(element = null): void {
    console.log('elemento: ', element)
    const dialogRef = this.dialog.open(NewProdDialogComponent, {
      data: { produto: element != null ? element : null},
      width: '100vw',
      height: '50%',
      backdropClass: 'test',
      panelClass: 'bg-white'
    })

    dialogRef.afterClosed().subscribe(_ => {
      this.getProdutos();
    })
  }

  Editar(element: any) {
    this.openDialog(element)
  }

}
