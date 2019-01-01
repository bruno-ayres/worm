import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WormSharedModule } from 'app/shared';
import {
    OpportunityComponent,
    OpportunityDetailComponent,
    OpportunityUpdateComponent,
    OpportunityDeletePopupComponent,
    OpportunityDeleteDialogComponent,
    opportunityRoute,
    opportunityPopupRoute
} from './';

const ENTITY_STATES = [...opportunityRoute, ...opportunityPopupRoute];

@NgModule({
    imports: [WormSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        OpportunityComponent,
        OpportunityDetailComponent,
        OpportunityUpdateComponent,
        OpportunityDeleteDialogComponent,
        OpportunityDeletePopupComponent
    ],
    entryComponents: [OpportunityComponent, OpportunityUpdateComponent, OpportunityDeleteDialogComponent, OpportunityDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WormOpportunityModule {}
