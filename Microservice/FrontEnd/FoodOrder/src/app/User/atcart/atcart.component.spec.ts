import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtcartComponent } from './atcart.component';

describe('AtcartComponent', () => {
  let component: AtcartComponent;
  let fixture: ComponentFixture<AtcartComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AtcartComponent]
    });
    fixture = TestBed.createComponent(AtcartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
