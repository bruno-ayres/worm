import { NgModule } from '@angular/core';
import { GrowlModule } from 'primeng/growl';
import { MessageService } from 'primeng/components/common/messageservice';

@NgModule({
    imports: [GrowlModule],
    providers: [MessageService],
    exports: [GrowlModule]
})
export class JhPrimeNgModule {}
