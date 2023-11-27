import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcoesPanComponent } from './acoes-pan.component';

describe('AcoesPanComponent', () => {
  let component: AcoesPanComponent;
  let fixture: ComponentFixture<AcoesPanComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AcoesPanComponent]
    });
    fixture = TestBed.createComponent(AcoesPanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
