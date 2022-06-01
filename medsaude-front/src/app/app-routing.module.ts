import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CriarContaComponent } from './conta/criar-conta/criar-conta.component';
import { LoginComponent } from './conta/login/login.component';
import { AutenticacaoComponent } from './layout/autenticacao/autenticacao.component';
import { HomeComponent } from './layout/home/home.component';
import { AuthGuard } from './conta/shared/auth.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      // { path: 'rotaAqui', component: ComponentAqui },
      // { path: 'rotaAqui', component: ComponentAqui },
      // { path: 'rotaAqui', component: ComponentAqui }
    ],
    canActivate: [AuthGuard]
  },
  {
    path: '',
    component: AutenticacaoComponent,
    children: [
      { path: '', redirectTo: 'login', pathMatch: 'full' },
      { path: 'login', component: LoginComponent },
      { path: 'criar-conta', component: CriarContaComponent }
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
