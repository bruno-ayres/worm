import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { IOpportunity } from 'app/shared/model/opportunity.model';
import { OpportunityService } from './opportunity.service';
import { ICustomer } from 'app/shared/model/customer.model';
import { CustomerService } from 'app/entities/customer';
import { IAccountManager } from 'app/shared/model/account-manager.model';
import { AccountManagerService } from 'app/entities/account-manager';

@Component({
    selector: 'jhi-opportunity-update',
    templateUrl: './opportunity-update.component.html'
})
export class OpportunityUpdateComponent implements OnInit {
    opportunity: IOpportunity;
    isSaving: boolean;

    customers: ICustomer[];

    accountmanagers: IAccountManager[];
    closeDate: string;

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected opportunityService: OpportunityService,
        protected customerService: CustomerService,
        protected accountManagerService: AccountManagerService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ opportunity }) => {
            this.opportunity = opportunity;
            this.closeDate = this.opportunity.closeDate != null ? this.opportunity.closeDate.format(DATE_TIME_FORMAT) : null;
        });
        this.customerService.query().subscribe(
            (res: HttpResponse<ICustomer[]>) => {
                this.customers = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.accountManagerService.query().subscribe(
            (res: HttpResponse<IAccountManager[]>) => {
                this.accountmanagers = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.opportunity.closeDate = this.closeDate != null ? moment(this.closeDate, DATE_TIME_FORMAT) : null;
        if (this.opportunity.id !== undefined) {
            this.subscribeToSaveResponse(this.opportunityService.update(this.opportunity));
        } else {
            this.subscribeToSaveResponse(this.opportunityService.create(this.opportunity));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IOpportunity>>) {
        result.subscribe((res: HttpResponse<IOpportunity>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackCustomerById(index: number, item: ICustomer) {
        return item.id;
    }

    trackAccountManagerById(index: number, item: IAccountManager) {
        return item.id;
    }
}
