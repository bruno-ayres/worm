import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import { WormSharedLibsModule, WormSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';
import { JhPrimeNgModule } from './prime-ng.module';
import { AgGridModule } from 'ag-grid-angular';

@NgModule({
    imports: [WormSharedLibsModule, WormSharedCommonModule, JhPrimeNgModule, AgGridModule.withComponents([])],
    declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    entryComponents: [JhiLoginModalComponent],
    exports: [WormSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective, JhPrimeNgModule, AgGridModule],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WormSharedModule {
    static forRoot() {
        return {
            ngModule: WormSharedModule
        };
    }
}
