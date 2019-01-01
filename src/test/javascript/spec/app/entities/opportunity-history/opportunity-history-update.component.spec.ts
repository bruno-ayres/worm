/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { WormTestModule } from '../../../test.module';
import { OpportunityHistoryUpdateComponent } from 'app/entities/opportunity-history/opportunity-history-update.component';
import { OpportunityHistoryService } from 'app/entities/opportunity-history/opportunity-history.service';
import { OpportunityHistory } from 'app/shared/model/opportunity-history.model';

describe('Component Tests', () => {
    describe('OpportunityHistory Management Update Component', () => {
        let comp: OpportunityHistoryUpdateComponent;
        let fixture: ComponentFixture<OpportunityHistoryUpdateComponent>;
        let service: OpportunityHistoryService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [WormTestModule],
                declarations: [OpportunityHistoryUpdateComponent]
            })
                .overrideTemplate(OpportunityHistoryUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(OpportunityHistoryUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(OpportunityHistoryService);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity', fakeAsync(() => {
                // GIVEN
                const entity = new OpportunityHistory(123);
                spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.opportunityHistory = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.update).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));

            it('Should call create service on save for new entity', fakeAsync(() => {
                // GIVEN
                const entity = new OpportunityHistory();
                spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.opportunityHistory = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.create).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));
        });
    });
});
