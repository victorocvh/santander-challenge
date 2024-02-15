import { Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { ClientesComponent } from './clientes/clientes.component';
import { FuncionarioComponent } from './funcionarios/funcionarios.component';

export const routes: Routes = [
    { path: 'main', component: MainComponent},
    {path: 'produto', component: ProdutosComponent},
    {path: 'cliente', component: ClientesComponent},
    {path: 'funcionario', component: FuncionarioComponent},
    { path: '', redirectTo: '/main', pathMatch: 'full'}
];
