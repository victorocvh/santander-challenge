import { Component, OnInit } from '@angular/core';
import Venda from '../../model/Venda';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import ProdutoService from '../../services/ProdutosService';
import Produto from '../../model/Produto';
import VendasService from '../../services/VendasService';
import Funcionario from '../../model/Funcionario';
import FuncionarioService from '../../services/FuncionarioService';
import { MatSelectModule } from '@angular/material/select';
import ClienteService from '../../services/ClienteService';
import Cliente from '../../model/Cliente';

@Component({
  selector: 'app-new-venda-dialog',
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
  templateUrl: './new-venda-dialog.component.html',
  styleUrl: './new-venda-dialog.component.css'
})
export class NewVendaDialogComponent implements OnInit {
  public venda = new Venda();
  public update = false;
  public funcionarioId = 0;
  
  public produtoList: Produto[] = [];
  public funcionarioList: Funcionario[] = [];
  public clienteList: Cliente[] = [];
  public fSelected: Funcionario | undefined = undefined;
  public pSelected: Produto | undefined = undefined;
  public cSelected: Cliente | undefined = undefined;

  constructor(private pService: ProdutoService,
    private vService: VendasService,
    private fService: FuncionarioService,
    private cService: ClienteService) {}

  ngOnInit(): void {
      this.pService.getProdutos().subscribe(res => {
        this.produtoList = res;
      })

      this.fService.getFuncionarios().subscribe(res => {
        this.funcionarioList = res;
      })

      this.cService.getClientes().subscribe(res => {
        this.clienteList = res;
      })
  }

  SendData() {
    this.vService.AddVenda(this.venda).subscribe(res => {
      console.log('venda: ' + res)
    })
  }
}
