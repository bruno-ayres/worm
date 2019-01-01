/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { WormTestModule } from '../../../test.module';
import { AccountManagerDeleteDialogComponent } from 'app/entities/account-manager/account-manager-delete-dialog.component';
import { AccountManagerService } from 'app/entities/account-manager/account-manager.service';

describe('Component Tests', () => {
    describe('AccountManager Management Delete Component', () => {
        let comp: AccountManagerDeleteDialogComponent;
        let fixture: ComponentFixture<AccountManagerDeleteDialogComponent>;
        let service: AccountManagerService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [WormTestModule],
                declarations: [AccountManagerDeleteDialogComponent]
            })
                .overrideTemplate(AccountManagerDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AccountManagerDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AccountManagerService);
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
