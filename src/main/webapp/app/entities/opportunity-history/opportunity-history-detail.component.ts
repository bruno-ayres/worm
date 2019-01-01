import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IOpportunityHistory } from 'app/shared/model/opportunity-history.model';

@Component({
    selector: 'jhi-opportunity-history-detail',
    templateUrl: './opportunity-history-detail.component.html'
})
export class OpportunityHistoryDetailComponent implements OnInit {
    opportunityHistory: IOpportunityHistory;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ opportunityHistory }) => {
            this.opportunityHistory = opportunityHistory;
        });
    }

    previousState() {
        window.history.back();
    }
}
