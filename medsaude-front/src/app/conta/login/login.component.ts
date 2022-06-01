import { Component, OnInit } from '@angular/core';
import {ContaService} from "../shared/conta.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login = {
    email: '',
    password: ''
  };

  constructor(
    private contaService: ContaService,
    private router: Router
  ) {

  }

  ngOnInit(): void {
  }

  async onSubmit() {
    try {
      const result = await this.contaService.login(this.login);
      console.log(`Login efetuado: ${result}`);

      // navego para a rota vazia novamente
      this.router.navigate(['']);
    } catch (error) {
      console.error(error);
    }
  }


}
