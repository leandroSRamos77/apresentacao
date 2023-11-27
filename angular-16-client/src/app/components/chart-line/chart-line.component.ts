import { Component } from '@angular/core';
import Chart from 'chart.js/auto';
import { InstrumentService } from 'src/app/services/instrument.service';

@Component({
  selector: 'app-chart-line',
  templateUrl: './chart-line.component.html',
  styleUrls: ['./chart-line.component.css'],
})
export class ChartLineComponent {
  title = 'ng-chart';
  chart: any = [];
  instrument: any;
  labels!: String[];
  priced: any[] = [];
  dated: any[] = [];
  instrumentAcaoBOVA11 = {
    label: String,
    price: [],
    data: [],
  };
  /**/
  priceBOVA11: any[] = [64.56];
  dateBOVA11: any[] = ['2017-05-02'];
  /**/
  /**/
  priceBPAN4F: any[] = [0];
  dateBPAN4F: any[] = ['2017-05-02'];
  /**/
  /**/
  priceITUB4F: any[] = [0];
  dateITUB4F: any[] = ['2017-05-02'];
  /**/
  /**/
  priceMGLU3F: any[] = [0];
  dateMGLU3F: any[] = ['2017-05-02'];
  /**/

  /**/
  priceVVAR3F: any[] = [0];
  dateVVAR3F: any[] = ['2017-05-02'];
  /**/
  constructor(private instrumentService: InstrumentService) {}

  ngOnInit() {
    this.GetAcoeGraphs();
  }


  GetAcoeGraphs(): void {
    this.instrumentService.getAllBOVA11().subscribe({
      next: (result) => {
        //instrumentAcaoBOVA11

        //this.instrumentAcaoBOVA11.price.concat(e.price);
        result.map((e) => {
          this.priced.push(e.price);
          this.priceBOVA11.push(e.price);
          this.dated.push(e.data);
          this.dateBOVA11.push(e.data);
        });
      },
      error: (e) => console.error(),
    });

    this.instrumentService.getAllBPAN4F().subscribe({
      next: (result) => {
        result.map((e) => {
          this.priceBPAN4F.push(e.price);
          this.dateBPAN4F.push(e.data);
        });
      },
      error: (e) => console.error(),
    });

    this.instrumentService.getAllITUB4F().subscribe({
      next: (result) => {
        result.map((e) => {
          this.priceITUB4F.push(e.price);
          this.dateITUB4F.push(e.data);
        });
      },
      error: (e) => console.error(),
    });

    this.instrumentService.getAllMGLU3F().subscribe({
      next: (result) => {
        result.map((e) => {
          this.priceMGLU3F.push(e.price);
          this.dateMGLU3F.push(e.data);
        });
      },
      error: (e) => console.error(),
    });


    this.instrumentService.getAllVVAR3F().subscribe({
      next: (result) => {
        result.map((e) => {
          this.priceVVAR3F.push(e.price);
          this.dateVVAR3F.push(e.data);
        });
      },
      error: (e) => console.error(),
    });


    const wait = async (milliseconds: number | undefined) => {
      await new Promise((resolve) => {
        return setTimeout(resolve, milliseconds);
      });
    };
    const testWait = async () => {
      await wait(1000);
      this.chart = new Chart('canvas2', {
        type: 'line',
        data: {
          labels: this.dateBOVA11,
          datasets: [
            {
              label: 'My BOVA11',
              data: this.priceBOVA11,
              fill: false,
              borderColor: 'rgb(75, 192, 192)',
              tension: 0.1,
            },
            {
              label: 'My BPAN4F',
              data: this.priceBPAN4F,
              fill: false,
              borderColor: 'rgb(255, 0, 0)',
              tension: 0.1,
            },
            {
              label: 'My ITUB4F',
              data: this.priceITUB4F,
              fill: false,
              borderColor: 'rgb(168, 123, 255)',
              tension: 0.1,
            },
            {
              label: 'My MGLU3F',
              data: this.priceMGLU3F,
              fill: false,
              borderColor: 'rgb(241, 30, 255)',
              tension: 0.1,
            },
            {
              label: 'My VVAR3F',
              data: this.priceVVAR3F,
              fill: false,
              borderColor: 'rgb(60, 229, 51)',
              tension: 0.1,
            },
          ],
        },
        options: {
          scales: {
            y: {
              beginAtZero: true,
            },
          },
        },
      });
    };
    testWait();
    /***************** */
  }
}

/**
 *
 *  datasets: [
          {
            label: 'My First Dataset',
            data: [65, 59, 80, 81, 56, 55, 40],
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1,
          },
          {
            label: 'My Second Dataset',
            data: [35, 29, 30, 91, 76, 25, 10],
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1,
          },
        ],
 */
