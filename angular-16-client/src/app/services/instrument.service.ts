import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Instrument } from '../models/instrument.model';

const baseUrl = 'http://localhost:8090/api2/instrument_quote';

@Injectable({
  providedIn: 'root',
})
export class InstrumentService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(baseUrl);
  }

  get(id: any): Observable<Instrument> {
    return this.http.get<Instrument>(`${baseUrl}/${id}`);
  }


  getData(data: any): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(`${baseUrl}/${data}`);
  }
}
