import { Component } from '@angular/core';
import { MatTabChangeEvent } from '@angular/material/tabs';
import { Instrument } from 'src/app/models/instrument.model';
import { InstrumentService } from 'src/app/services/instrument.service';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],

})
export class UserListComponent {
  instrument?: Instrument[];
  currentInstrument: Instrument = {};
  currentIndex = -1;
  title:string = '';
  instrumentData?: Instrument[];


  constructor(private instrumentService: InstrumentService) {}

  ngOnInit(): void {
    this.retrieveInstruments();
  }

  retrieveIntrumentsData(){
    this.instrumentService.getData('2020-04-01').subscribe({
      next: (data) => {
        this.instrumentData = data;
        console.log(data);
        console.log(this.instrumentData);
      },
      error: (e) => console.error(e)
    });
  }
  retrieveInstruments(): void {
    this.instrumentService.getAll().subscribe({
      next: (data) => {
        this.instrument = data;
       // console.log(data);
       // console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  setActiveInstrument(instrument: Instrument, index: number): void {
    this.currentInstrument = instrument;
    this.currentIndex = index;
  }

  tabChanged(tabChangeEvent: MatTabChangeEvent): void {
    console.log('tabChangeEvent => ', tabChangeEvent);
    console.log('index => ', tabChangeEvent.index);
  }
}
