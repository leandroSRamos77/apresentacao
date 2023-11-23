import { Component } from '@angular/core';
import Chart from 'chart.js/auto';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular 16 Crud example';

 // title = 'ng-chart';
  chart: any = [];

  constructor() {}

  ngOnInit() {
    this.chart = new Chart('canvas', {
      type: 'bar',
      data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [
          {
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            borderWidth: 1,
          },
          {
            label: '# of Votes 2020',
            data: [3, 12, 3, 19, 2, 5],
            borderWidth: 1,
          },
          {
            label: '# of Votes 2023',
            data: [5, 3, 3, 19, 12, 5],
            borderWidth: 1,
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
  }
}
