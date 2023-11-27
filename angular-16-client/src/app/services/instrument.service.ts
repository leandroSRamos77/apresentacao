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

  getAllBOVA11(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(`${baseUrl}?simbol=BOVA11`);
  }

  getAllBPAN4F(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(`${baseUrl}?simbol=BPAN4F`);
  }

  getAllITUB4F(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(`${baseUrl}?simbol=ITUB4F`);
  }
  /**Magazine Luiza */
  getAllMGLU3F(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(`${baseUrl}?simbol=MGLU3F`);
  }
  /**VIAVAREJO */
  getAllVVAR3F(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(`${baseUrl}?simbol=VVAR3F`);
  }

  get(id: any): Observable<Instrument> {
    return this.http.get<Instrument>(`${baseUrl}/${id}`);
  }


  getData(data: any): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(`${baseUrl}/${data}`);
  }
}
