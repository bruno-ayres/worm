import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IOpportunityHistory } from 'app/shared/model/opportunity-history.model';
import { OpportunityHistoryService } from './opportunity-history.service';

@Component({
    selector: 'jhi-opportunity-history-delete-dialog',
    templateUrl: './opportunity-history-delete-dialog.component.html'
})
export class OpportunityHistoryDeleteDialogComponent {
    opportunityHistory: IOpportunityHistory;

    constructor(
        protected opportunityHistoryService: OpportunityHistoryService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.opportunityHistoryService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'opportunityHistoryListModification',
                content: 'Deleted an opportunityHistory'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-opportunity-history-delete-popup',
    template: ''
})
export class OpportunityHistoryDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ opportunityHistory }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(OpportunityHistoryDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.opportunityHistory = opportunityHistory;
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
