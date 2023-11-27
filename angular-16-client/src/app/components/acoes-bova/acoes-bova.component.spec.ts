import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcoesBovaComponent } from './acoes-bova.component';

describe('AcoesBovaComponent', () => {
  let component: AcoesBovaComponent;
  let fixture: ComponentFixture<AcoesBovaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AcoesBovaComponent]
    });
    fixture = TestBed.createComponent(AcoesBovaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
