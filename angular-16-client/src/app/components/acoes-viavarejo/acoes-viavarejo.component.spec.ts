import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcoesViavarejoComponent } from './acoes-viavarejo.component';

describe('AcoesViavarejoComponent', () => {
  let component: AcoesViavarejoComponent;
  let fixture: ComponentFixture<AcoesViavarejoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AcoesViavarejoComponent]
    });
    fixture = TestBed.createComponent(AcoesViavarejoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
