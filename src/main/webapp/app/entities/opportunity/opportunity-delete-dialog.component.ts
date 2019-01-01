import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IOpportunity } from 'app/shared/model/opportunity.model';
import { OpportunityService } from './opportunity.service';

@Component({
    selector: 'jhi-opportunity-delete-dialog',
    templateUrl: './opportunity-delete-dialog.component.html'
})
export class OpportunityDeleteDialogComponent {
    opportunity: IOpportunity;

    constructor(
        protected opportunityService: OpportunityService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.opportunityService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'opportunityListModification',
                content: 'Deleted an opportunity'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-opportunity-delete-popup',
    template: ''
})
export class OpportunityDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ opportunity }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(OpportunityDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.opportunity = opportunity;
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
