import { Component } from '@angular/core';
import { AcoesService } from 'src/app/services/acoes.service';

@Component({
  selector: 'app-acoes-mag-luiza',
  templateUrl: './acoes-mag-luiza.component.html',
  styleUrls: ['./acoes-mag-luiza.component.css']
})
export class AcoesMagLuizaComponent {
  saldoTotal:number =0;
  acoesPrintNaTela:any[] = [];
  constructor(private acoesService: AcoesService) {}

  ngOnInit(): void {
    this.chamadaDasAcoes();
  }

  chamadaDasAcoes(){
    this.acoesService.getAllMGLU3F().subscribe({
      next: (data:any) => {
        data.map((e:any,i:number)=>{ //parseFloat(num).toFixed(2)
          if(e['2'] == 'V'){
            this.saldoTotal +=(e['1']*e['5']);
          }
          this.acoesPrintNaTela.push({

            valorData:  e['6'],
            valorAnterior:e['0'],
            valorCompra:e['1'],
            valorOperacao:e['2'],
            valorQuantidade:e['5'],
            valorPorcentagem:(e['0']==null)?  e['1']: (((e['0'] - e['1'])/e['0']) * 100).toFixed(2)
          })
        })

      }
    });
    console.log(this.acoesPrintNaTela);
  }
}
