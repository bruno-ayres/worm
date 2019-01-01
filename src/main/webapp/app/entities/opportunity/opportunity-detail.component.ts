import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IOpportunity } from 'app/shared/model/opportunity.model';

@Component({
    selector: 'jhi-opportunity-detail',
    templateUrl: './opportunity-detail.component.html'
})
export class OpportunityDetailComponent implements OnInit {
    opportunity: IOpportunity;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ opportunity }) => {
            this.opportunity = opportunity;
        });
    }

    previousState() {
        window.history.back();
    }
}
