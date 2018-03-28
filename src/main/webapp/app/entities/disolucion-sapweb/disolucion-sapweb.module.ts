import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DemojhipsterSharedModule } from '../../shared';
import {
    DisolucionSapwebService,
    DisolucionSapwebPopupService,
    DisolucionSapwebComponent,
    DisolucionSapwebDetailComponent,
    DisolucionSapwebDialogComponent,
    DisolucionSapwebPopupComponent,
    DisolucionSapwebDeletePopupComponent,
    DisolucionSapwebDeleteDialogComponent,
    disolucionRoute,
    disolucionPopupRoute,
    DisolucionSapwebResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...disolucionRoute,
    ...disolucionPopupRoute,
];

@NgModule({
    imports: [
        DemojhipsterSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        DisolucionSapwebComponent,
        DisolucionSapwebDetailComponent,
        DisolucionSapwebDialogComponent,
        DisolucionSapwebDeleteDialogComponent,
        DisolucionSapwebPopupComponent,
        DisolucionSapwebDeletePopupComponent,
    ],
    entryComponents: [
        DisolucionSapwebComponent,
        DisolucionSapwebDialogComponent,
        DisolucionSapwebPopupComponent,
        DisolucionSapwebDeleteDialogComponent,
        DisolucionSapwebDeletePopupComponent,
    ],
    providers: [
        DisolucionSapwebService,
        DisolucionSapwebPopupService,
        DisolucionSapwebResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemojhipsterDisolucionSapwebModule {}
