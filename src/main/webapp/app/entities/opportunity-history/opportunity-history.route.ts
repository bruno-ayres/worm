import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { OpportunityHistory } from 'app/shared/model/opportunity-history.model';
import { OpportunityHistoryService } from './opportunity-history.service';
import { OpportunityHistoryComponent } from './opportunity-history.component';
import { OpportunityHistoryDetailComponent } from './opportunity-history-detail.component';
import { OpportunityHistoryUpdateComponent } from './opportunity-history-update.component';
import { OpportunityHistoryDeletePopupComponent } from './opportunity-history-delete-dialog.component';
import { IOpportunityHistory } from 'app/shared/model/opportunity-history.model';

@Injectable({ providedIn: 'root' })
export class OpportunityHistoryResolve implements Resolve<IOpportunityHistory> {
    constructor(private service: OpportunityHistoryService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<OpportunityHistory> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<OpportunityHistory>) => response.ok),
                map((opportunityHistory: HttpResponse<OpportunityHistory>) => opportunityHistory.body)
            );
        }
        return of(new OpportunityHistory());
    }
}

export const opportunityHistoryRoute: Routes = [
    {
        path: 'opportunity-history',
        component: OpportunityHistoryComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'wormApp.opportunityHistory.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'opportunity-history/:id/view',
        component: OpportunityHistoryDetailComponent,
        resolve: {
            opportunityHistory: OpportunityHistoryResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.opportunityHistory.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'opportunity-history/new',
        component: OpportunityHistoryUpdateComponent,
        resolve: {
            opportunityHistory: OpportunityHistoryResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.opportunityHistory.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'opportunity-history/:id/edit',
        component: OpportunityHistoryUpdateComponent,
        resolve: {
            opportunityHistory: OpportunityHistoryResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.opportunityHistory.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const opportunityHistoryPopupRoute: Routes = [
    {
        path: 'opportunity-history/:id/delete',
        component: OpportunityHistoryDeletePopupComponent,
        resolve: {
            opportunityHistory: OpportunityHistoryResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.opportunityHistory.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
