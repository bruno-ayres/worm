import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Opportunity } from 'app/shared/model/opportunity.model';
import { OpportunityService } from './opportunity.service';
import { OpportunityComponent } from './opportunity.component';
import { OpportunityDetailComponent } from './opportunity-detail.component';
import { OpportunityUpdateComponent } from './opportunity-update.component';
import { OpportunityDeletePopupComponent } from './opportunity-delete-dialog.component';
import { IOpportunity } from 'app/shared/model/opportunity.model';

@Injectable({ providedIn: 'root' })
export class OpportunityResolve implements Resolve<IOpportunity> {
    constructor(private service: OpportunityService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Opportunity> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Opportunity>) => response.ok),
                map((opportunity: HttpResponse<Opportunity>) => opportunity.body)
            );
        }
        return of(new Opportunity());
    }
}

export const opportunityRoute: Routes = [
    {
        path: 'opportunity',
        component: OpportunityComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'wormApp.opportunity.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'opportunity/:id/view',
        component: OpportunityDetailComponent,
        resolve: {
            opportunity: OpportunityResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.opportunity.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'opportunity/new',
        component: OpportunityUpdateComponent,
        resolve: {
            opportunity: OpportunityResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.opportunity.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'opportunity/:id/edit',
        component: OpportunityUpdateComponent,
        resolve: {
            opportunity: OpportunityResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.opportunity.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const opportunityPopupRoute: Routes = [
    {
        path: 'opportunity/:id/delete',
        component: OpportunityDeletePopupComponent,
        resolve: {
            opportunity: OpportunityResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.opportunity.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
