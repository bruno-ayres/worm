/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { WormTestModule } from '../../../test.module';
import { AccountManagerDetailComponent } from 'app/entities/account-manager/account-manager-detail.component';
import { AccountManager } from 'app/shared/model/account-manager.model';

describe('Component Tests', () => {
    describe('AccountManager Management Detail Component', () => {
        let comp: AccountManagerDetailComponent;
        let fixture: ComponentFixture<AccountManagerDetailComponent>;
        const route = ({ data: of({ accountManager: new AccountManager(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [WormTestModule],
                declarations: [AccountManagerDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(AccountManagerDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AccountManagerDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.accountManager).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
