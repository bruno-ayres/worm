import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { WormCustomerModule } from './customer/customer.module';
import { WormAccountManagerModule } from './account-manager/account-manager.module';
import { WormOpportunityModule } from './opportunity/opportunity.module';
import { WormOpportunityHistoryModule } from './opportunity-history/opportunity-history.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        WormCustomerModule,
        WormAccountManagerModule,
        WormOpportunityModule,
        WormOpportunityHistoryModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WormEntityModule {}
