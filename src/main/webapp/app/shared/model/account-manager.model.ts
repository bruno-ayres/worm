export interface IAccountManager {
    id?: number;
    name?: string;
    active?: boolean;
}

export class AccountManager implements IAccountManager {
    constructor(public id?: number, public name?: string, public active?: boolean) {
        this.active = this.active || false;
    }
}
