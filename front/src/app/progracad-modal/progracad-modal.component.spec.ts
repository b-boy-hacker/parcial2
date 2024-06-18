import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgracadModalComponent } from './progracad-modal.component';

describe('ProgracadModalComponent', () => {
  let component: ProgracadModalComponent;
  let fixture: ComponentFixture<ProgracadModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProgracadModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProgracadModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
