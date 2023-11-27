import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcoesItauComponent } from './acoes-itau.component';

describe('AcoesItauComponent', () => {
  let component: AcoesItauComponent;
  let fixture: ComponentFixture<AcoesItauComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AcoesItauComponent]
    });
    fixture = TestBed.createComponent(AcoesItauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
