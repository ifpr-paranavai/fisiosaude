import { Component, OnInit } from '@angular/core';
import {ContaService} from "../shared/conta.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-criar-conta',
  templateUrl: './criar-conta.component.html',
  styleUrls: ['./criar-conta.component.css']
})
export class CriarContaComponent implements OnInit {

  conta = {
    nome: '',
    email: '',
    senha: ''
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
      const result = await this.contaService.criarConta(this.conta);

      //exibir msg amigavel que a conta foi criada
      console.log(result);

    } catch (error) {
      console.error(error);
    }
  }

}
