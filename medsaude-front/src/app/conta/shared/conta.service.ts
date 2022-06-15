import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import jwtDecode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class ContaService {

  constructor(private http: HttpClient) { }

  async login(user: any) {
    const result = await this.http.post<any>(`${environment.api}/v1/auth/login`, user).toPromise();
    if (result && result.type === "Bearer" && result.token) {
      window.localStorage.setItem('token', result.token);
      return true;
    }

    return false;
  }

  async criarConta(conta: any) {
    const result = await this.http.post<any>(`${environment.api}/v1/auth/cadastrar`, conta).toPromise();
    if (result && result.type === "Bearer" && result.token) {
      window.localStorage.setItem('token', result.token);
      return true;
    }

    return false;

  }

  async getUserById(id: any) {
    const result = await this.http.get<any>(`${environment.api}/v1/test/getUsuario/1`).toPromise();


    return false;
  }

  getAuthorizationToken() {
    const token = window.localStorage.getItem('token');
    return token;
  }

  getTokenExpirationDate(token: string): Date | null {
    const decoded: any = jwtDecode(token);

    if (decoded.exp === undefined) {
      return null;
    }

    const date = new Date(0);
    date.setUTCSeconds(decoded.exp);
    return date;
  }

  isTokenExpired(token?: string): boolean {
    if (!token) {
      return true;
    }

    const date = this.getTokenExpirationDate(token);
    if (date === undefined) {
      return false;
    }

    // @ts-ignore
    return !(date.valueOf() > new Date().valueOf());
  }

  isUserLoggedIn() {
    const token = this.getAuthorizationToken();
    if (!token) {
      return false;
    } else if (this.isTokenExpired(token)) {
      return false;
    }

    return true;
  }

}
