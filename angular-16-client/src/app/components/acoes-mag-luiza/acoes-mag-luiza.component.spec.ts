import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcoesMagLuizaComponent } from './acoes-mag-luiza.component';

describe('AcoesMagLuizaComponent', () => {
  let component: AcoesMagLuizaComponent;
  let fixture: ComponentFixture<AcoesMagLuizaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AcoesMagLuizaComponent]
    });
    fixture = TestBed.createComponent(AcoesMagLuizaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
