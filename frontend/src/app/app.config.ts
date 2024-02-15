import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';
import ProdutoService from './services/ProdutosService';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import VendasService from './services/VendasService';
import FuncionarioService from './services/FuncionarioService';
import ClienteService from './services/ClienteService';
import TipoFuncionarioService from './services/TipoFuncionarioService';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideClientHydration(),
    importProvidersFrom(HttpClientModule),
    importProvidersFrom(HttpClientJsonpModule),
    ProdutoService, provideAnimationsAsync(),
    VendasService,
    FuncionarioService,
    ClienteService,
    TipoFuncionarioService
  ],
};
