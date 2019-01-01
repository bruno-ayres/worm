import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { AccountManager } from 'app/shared/model/account-manager.model';
import { AccountManagerService } from './account-manager.service';
import { AccountManagerComponent } from './account-manager.component';
import { AccountManagerDetailComponent } from './account-manager-detail.component';
import { AccountManagerUpdateComponent } from './account-manager-update.component';
import { AccountManagerDeletePopupComponent } from './account-manager-delete-dialog.component';
import { IAccountManager } from 'app/shared/model/account-manager.model';

@Injectable({ providedIn: 'root' })
export class AccountManagerResolve implements Resolve<IAccountManager> {
    constructor(private service: AccountManagerService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<AccountManager> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<AccountManager>) => response.ok),
                map((accountManager: HttpResponse<AccountManager>) => accountManager.body)
            );
        }
        return of(new AccountManager());
    }
}

export const accountManagerRoute: Routes = [
    {
        path: 'account-manager',
        component: AccountManagerComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'wormApp.accountManager.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'account-manager/:id/view',
        component: AccountManagerDetailComponent,
        resolve: {
            accountManager: AccountManagerResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.accountManager.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'account-manager/new',
        component: AccountManagerUpdateComponent,
        resolve: {
            accountManager: AccountManagerResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.accountManager.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'account-manager/:id/edit',
        component: AccountManagerUpdateComponent,
        resolve: {
            accountManager: AccountManagerResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.accountManager.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const accountManagerPopupRoute: Routes = [
    {
        path: 'account-manager/:id/delete',
        component: AccountManagerDeletePopupComponent,
        resolve: {
            accountManager: AccountManagerResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'wormApp.accountManager.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
