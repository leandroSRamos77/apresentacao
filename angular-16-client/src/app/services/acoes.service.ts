import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Acoes } from '../models/acoes.model';

const baseUrl = 'http://localhost:8090/api3/usertrade/vendas';

@Injectable({
  providedIn: 'root',
})
export class AcoesService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<Acoes[]> {
    return this.http.get<Acoes[]>(baseUrl);
  }
  getAllBOVA11(): Observable<Acoes[]> {
    return this.http.get<Acoes[]>(`${baseUrl}?name=BOVA11`);
  }

  getAllBPAN4F(): Observable<Acoes[]> {
    return this.http.get<Acoes[]>(`${baseUrl}?name=BPAN4F`);
  }

  getAllITUB4F(): Observable<Acoes[]> {
    return this.http.get<Acoes[]>(`${baseUrl}?name=ITUB4F`);
  }
  /**Magazine Luiza */
  getAllMGLU3F(): Observable<Acoes[]> {
    return this.http.get<Acoes[]>(`${baseUrl}?name=MGLU3F`);
  }
  /**VIAVAREJO */
  getAllVVAR3F(): Observable<Acoes[]> {
    return this.http.get<Acoes[]>(`${baseUrl}?name=VVAR3F`);
  }
}
