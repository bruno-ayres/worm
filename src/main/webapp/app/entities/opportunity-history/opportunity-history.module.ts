import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WormSharedModule } from 'app/shared';
import {
    OpportunityHistoryComponent,
    OpportunityHistoryDetailComponent,
    OpportunityHistoryUpdateComponent,
    OpportunityHistoryDeletePopupComponent,
    OpportunityHistoryDeleteDialogComponent,
    opportunityHistoryRoute,
    opportunityHistoryPopupRoute
} from './';

const ENTITY_STATES = [...opportunityHistoryRoute, ...opportunityHistoryPopupRoute];

@NgModule({
    imports: [WormSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        OpportunityHistoryComponent,
        OpportunityHistoryDetailComponent,
        OpportunityHistoryUpdateComponent,
        OpportunityHistoryDeleteDialogComponent,
        OpportunityHistoryDeletePopupComponent
    ],
    entryComponents: [
        OpportunityHistoryComponent,
        OpportunityHistoryUpdateComponent,
        OpportunityHistoryDeleteDialogComponent,
        OpportunityHistoryDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WormOpportunityHistoryModule {}
