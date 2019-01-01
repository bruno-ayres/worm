export const enum OpportunityStatus {
    RESERVED = 'RESERVED',
    PREPARING = 'PREPARING',
    SENT = 'SENT',
    WON = 'WON',
    DECLINED = 'DECLINED'
}

export interface IOpportunityHistory {
    id?: number;
    status?: OpportunityStatus;
    opportunityTitle?: string;
    opportunityId?: number;
}

export class OpportunityHistory implements IOpportunityHistory {
    constructor(public id?: number, public status?: OpportunityStatus, public opportunityTitle?: string, public opportunityId?: number) {}
}
