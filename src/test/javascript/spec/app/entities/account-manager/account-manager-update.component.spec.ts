/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { WormTestModule } from '../../../test.module';
import { AccountManagerUpdateComponent } from 'app/entities/account-manager/account-manager-update.component';
import { AccountManagerService } from 'app/entities/account-manager/account-manager.service';
import { AccountManager } from 'app/shared/model/account-manager.model';

describe('Component Tests', () => {
    describe('AccountManager Management Update Component', () => {
        let comp: AccountManagerUpdateComponent;
        let fixture: ComponentFixture<AccountManagerUpdateComponent>;
        let service: AccountManagerService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [WormTestModule],
                declarations: [AccountManagerUpdateComponent]
            })
                .overrideTemplate(AccountManagerUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AccountManagerUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AccountManagerService);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity', fakeAsync(() => {
                // GIVEN
                const entity = new AccountManager(123);
                spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.accountManager = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.update).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));

            it('Should call create service on save for new entity', fakeAsync(() => {
                // GIVEN
                const entity = new AccountManager();
                spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.accountManager = entity;
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
