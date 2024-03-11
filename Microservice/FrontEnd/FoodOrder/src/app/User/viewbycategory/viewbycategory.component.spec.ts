import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewbycategoryComponent } from './viewbycategory.component';

describe('ViewbycategoryComponent', () => {
  let component: ViewbycategoryComponent;
  let fixture: ComponentFixture<ViewbycategoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewbycategoryComponent]
    });
    fixture = TestBed.createComponent(ViewbycategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
