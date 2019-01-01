import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IOpportunityHistory } from 'app/shared/model/opportunity-history.model';

type EntityResponseType = HttpResponse<IOpportunityHistory>;
type EntityArrayResponseType = HttpResponse<IOpportunityHistory[]>;

@Injectable({ providedIn: 'root' })
export class OpportunityHistoryService {
    public resourceUrl = SERVER_API_URL + 'api/opportunity-histories';

    constructor(protected http: HttpClient) {}

    create(opportunityHistory: IOpportunityHistory): Observable<EntityResponseType> {
        return this.http.post<IOpportunityHistory>(this.resourceUrl, opportunityHistory, { observe: 'response' });
    }

    update(opportunityHistory: IOpportunityHistory): Observable<EntityResponseType> {
        return this.http.put<IOpportunityHistory>(this.resourceUrl, opportunityHistory, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IOpportunityHistory>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IOpportunityHistory[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
