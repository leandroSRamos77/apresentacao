import { Component } from '@angular/core';
import Chart from 'chart.js/auto';

@Component({
  selector: 'app-chart-bar',
  templateUrl: './chart-bar.component.html',
  styleUrls: ['./chart-bar.component.css']
})
export class ChartBarComponent {
 title = 'ng-chart';
 chart: any = [];

 constructor() {}

 ngOnInit() {
   this.chart = new Chart('canvas', {
     type: 'bar',
     data: {
       labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
       datasets: [
         {
           label: 'BOVA11',
           data: [12, 19, 3, 5, 2, 3,90,2,3,50,30],
           borderWidth: 1,
         },
         {
           label: 'BPAN4F',
           data: [3, 12, 3, 19, 2, 5,90,2,3,50,30],
           borderWidth: 1,
         },
         {
           label: 'MGLU3F',
           data: [5, 3, 3, 19, 12, 5,90,2,3,50,30],
           borderWidth: 1,
         },
         {
          label: 'VVAR3F',
          data: [5, 3, 3, 19, 12, 5,90,2,3,50,30],
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
