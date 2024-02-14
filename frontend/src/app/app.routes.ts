import { Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
import { ProdutosComponent } from './produtos/produtos.component';

export const routes: Routes = [
    { path: 'main', component: MainComponent},
    {path: 'produto', component: ProdutosComponent},
    { path: '', redirectTo: '/main', pathMatch: 'full'}
];
