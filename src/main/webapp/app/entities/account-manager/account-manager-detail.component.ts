import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAccountManager } from 'app/shared/model/account-manager.model';

@Component({
    selector: 'jhi-account-manager-detail',
    templateUrl: './account-manager-detail.component.html'
})
export class AccountManagerDetailComponent implements OnInit {
    accountManager: IAccountManager;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ accountManager }) => {
            this.accountManager = accountManager;
        });
    }

    previousState() {
        window.history.back();
    }
}
