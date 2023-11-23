import { Component } from '@angular/core';
import Chart from 'chart.js/auto';

@Component({
  selector: 'app-chart-line',
  templateUrl: './chart-line.component.html',
  styleUrls: ['./chart-line.component.css']
})
export class ChartLineComponent {
  title = 'ng-chart';
  chart: any = [];

  constructor() {}

  ngOnInit() {
    this.chart = new Chart('canvas2', {
      type: 'line',
      data: {
        labels: ['2017', '2018', '2018', '2019', '2020', 'Orange'],
        datasets: [{
          label: 'My First Dataset',
          data: [65, 59, 80, 81, 56, 55, 40],
          fill: false,
          borderColor: 'rgb(75, 192, 192)',
          tension: 0.1
        },{
          label: 'My Second Dataset',
          data: [35, 29, 30, 91, 76, 25, 10],
          fill: false,
          borderColor: 'rgb(75, 192, 192)',
          tension: 0.1
        }
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
  }
}
