import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IAccountManager } from 'app/shared/model/account-manager.model';
import { AccountManagerService } from './account-manager.service';

@Component({
    selector: 'jhi-account-manager-update',
    templateUrl: './account-manager-update.component.html'
})
export class AccountManagerUpdateComponent implements OnInit {
    accountManager: IAccountManager;
    isSaving: boolean;

    constructor(protected accountManagerService: AccountManagerService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ accountManager }) => {
            this.accountManager = accountManager;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.accountManager.id !== undefined) {
            this.subscribeToSaveResponse(this.accountManagerService.update(this.accountManager));
        } else {
            this.subscribeToSaveResponse(this.accountManagerService.create(this.accountManager));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IAccountManager>>) {
        result.subscribe((res: HttpResponse<IAccountManager>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
