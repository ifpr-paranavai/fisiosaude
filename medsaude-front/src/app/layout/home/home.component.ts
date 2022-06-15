import { Component, OnInit } from '@angular/core';
import {ContaService} from "../../conta/shared/conta.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor( private contaService: ContaService,
               private router: Router) { }

  ngOnInit(): void {
  }

  async getTeste() {
    try {


      const result = await this.contaService.getUserById(1);
      console.log(`Login efetuado: ${result}`);

      // navego para a rota vazia novamente
      this.router.navigate(['']);
    } catch (error) {
      console.error(error);
    }
  }

}
