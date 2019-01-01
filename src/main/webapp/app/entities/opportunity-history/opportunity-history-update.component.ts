import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IOpportunityHistory } from 'app/shared/model/opportunity-history.model';
import { OpportunityHistoryService } from './opportunity-history.service';
import { IOpportunity } from 'app/shared/model/opportunity.model';
import { OpportunityService } from 'app/entities/opportunity';

@Component({
    selector: 'jhi-opportunity-history-update',
    templateUrl: './opportunity-history-update.component.html'
})
export class OpportunityHistoryUpdateComponent implements OnInit {
    opportunityHistory: IOpportunityHistory;
    isSaving: boolean;

    opportunities: IOpportunity[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected opportunityHistoryService: OpportunityHistoryService,
        protected opportunityService: OpportunityService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ opportunityHistory }) => {
            this.opportunityHistory = opportunityHistory;
        });
        this.opportunityService.query().subscribe(
            (res: HttpResponse<IOpportunity[]>) => {
                this.opportunities = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.opportunityHistory.id !== undefined) {
            this.subscribeToSaveResponse(this.opportunityHistoryService.update(this.opportunityHistory));
        } else {
            this.subscribeToSaveResponse(this.opportunityHistoryService.create(this.opportunityHistory));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IOpportunityHistory>>) {
        result.subscribe((res: HttpResponse<IOpportunityHistory>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackOpportunityById(index: number, item: IOpportunity) {
        return item.id;
    }
}
