import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WormSharedModule } from 'app/shared';
import {
    AccountManagerComponent,
    AccountManagerDetailComponent,
    AccountManagerUpdateComponent,
    AccountManagerDeletePopupComponent,
    AccountManagerDeleteDialogComponent,
    accountManagerRoute,
    accountManagerPopupRoute
} from './';

const ENTITY_STATES = [...accountManagerRoute, ...accountManagerPopupRoute];

@NgModule({
    imports: [WormSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AccountManagerComponent,
        AccountManagerDetailComponent,
        AccountManagerUpdateComponent,
        AccountManagerDeleteDialogComponent,
        AccountManagerDeletePopupComponent
    ],
    entryComponents: [
        AccountManagerComponent,
        AccountManagerUpdateComponent,
        AccountManagerDeleteDialogComponent,
        AccountManagerDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WormAccountManagerModule {}
