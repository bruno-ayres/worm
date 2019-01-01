import { Moment } from 'moment';
import { IOpportunityHistory } from 'app/shared/model//opportunity-history.model';

export const enum OpportunityStatus {
    RESERVED = 'RESERVED',
    PREPARING = 'PREPARING',
    SENT = 'SENT',
    WON = 'WON',
    DECLINED = 'DECLINED'
}

export interface IOpportunity {
    id?: number;
    title?: string;
    status?: OpportunityStatus;
    probability?: number;
    tcv?: number;
    closeDate?: Moment;
    opportunityHistories?: IOpportunityHistory[];
    customerName?: string;
    customerId?: number;
    accountManagerName?: string;
    accountManagerId?: number;
}

export class Opportunity implements IOpportunity {
    constructor(
        public id?: number,
        public title?: string,
        public status?: OpportunityStatus,
        public probability?: number,
        public tcv?: number,
        public closeDate?: Moment,
        public opportunityHistories?: IOpportunityHistory[],
        public customerName?: string,
        public customerId?: number,
        public accountManagerName?: string,
        public accountManagerId?: number
    ) {}
}
