import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAccountManager } from 'app/shared/model/account-manager.model';
import { AccountManagerService } from './account-manager.service';

@Component({
    selector: 'jhi-account-manager-delete-dialog',
    templateUrl: './account-manager-delete-dialog.component.html'
})
export class AccountManagerDeleteDialogComponent {
    accountManager: IAccountManager;

    constructor(
        protected accountManagerService: AccountManagerService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.accountManagerService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'accountManagerListModification',
                content: 'Deleted an accountManager'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-account-manager-delete-popup',
    template: ''
})
export class AccountManagerDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ accountManager }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(AccountManagerDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.accountManager = accountManager;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
