import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { InstrumentService } from './instrument.service';
import { Instrument } from '../models/instrument.model';
import { of } from 'rxjs';

describe('InstrumentService', () => {
  let httpClientSpy: jasmine.SpyObj<HttpClient>;
  let instrumentService: InstrumentService;
  const baseUrl = 'http://localhost:8090/api2/instrument_quote';

  beforeEach(() => {
    const spy = jasmine.createSpyObj('HttpClient', ['get']);

    TestBed.configureTestingModule({
      providers: [
        InstrumentService,
        { provide: HttpClient, useValue: spy }
      ]
    });

    httpClientSpy = TestBed.inject(HttpClient) as jasmine.SpyObj<HttpClient>;
    instrumentService = TestBed.inject(InstrumentService);
  });

  // Your tests go here


  it('should return an Observable<Instrument[]>', () => {
    const expectedInstruments: Instrument[] = [
      { /* your instrument data */ },
      { /* another instrument data */ }
      // Add more as needed
    ];

    httpClientSpy.get.and.returnValue(of(expectedInstruments));

    instrumentService.getAll().subscribe(
      instruments => expect(instruments).toEqual(expectedInstruments, 'expected instruments'),
      fail
    );

    // Verify that the method was called with the correct URL
    expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');
    expect(httpClientSpy.get.calls.mostRecent().args[0]).toBe(baseUrl, 'URL');
  });

});
