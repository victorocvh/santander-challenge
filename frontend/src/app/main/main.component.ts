import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import VendasService from '../services/VendasService';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ["nomeCliente","nomeFuncionario","tipoFuncionario","nomeProduto","valorTotal","quantidade","dataVenda"]
  dataSource = new MatTableDataSource<any>([]);
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private vendasService: VendasService) {}
  
  
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
}
