/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { WormTestModule } from '../../../test.module';
import { OpportunityDeleteDialogComponent } from 'app/entities/opportunity/opportunity-delete-dialog.component';
import { OpportunityService } from 'app/entities/opportunity/opportunity.service';

describe('Component Tests', () => {
    describe('Opportunity Management Delete Component', () => {
        let comp: OpportunityDeleteDialogComponent;
        let fixture: ComponentFixture<OpportunityDeleteDialogComponent>;
        let service: OpportunityService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [WormTestModule],
                declarations: [OpportunityDeleteDialogComponent]
            })
                .overrideTemplate(OpportunityDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(OpportunityDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(OpportunityService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
