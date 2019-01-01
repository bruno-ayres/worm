import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAccountManager } from 'app/shared/model/account-manager.model';

type EntityResponseType = HttpResponse<IAccountManager>;
type EntityArrayResponseType = HttpResponse<IAccountManager[]>;

@Injectable({ providedIn: 'root' })
export class AccountManagerService {
    public resourceUrl = SERVER_API_URL + 'api/account-managers';

    constructor(protected http: HttpClient) {}

    create(accountManager: IAccountManager): Observable<EntityResponseType> {
        return this.http.post<IAccountManager>(this.resourceUrl, accountManager, { observe: 'response' });
    }

    update(accountManager: IAccountManager): Observable<EntityResponseType> {
        return this.http.put<IAccountManager>(this.resourceUrl, accountManager, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IAccountManager>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IAccountManager[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
