import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DemojhipsterSharedModule } from '../../shared';
import {
    CargaSocvigSapwebService,
    CargaSocvigSapwebPopupService,
    CargaSocvigSapwebComponent,
    CargaSocvigSapwebDetailComponent,
    CargaSocvigSapwebDialogComponent,
    CargaSocvigSapwebPopupComponent,
    CargaSocvigSapwebDeletePopupComponent,
    CargaSocvigSapwebDeleteDialogComponent,
    cargaSocvigRoute,
    cargaSocvigPopupRoute,
} from './';

const ENTITY_STATES = [
    ...cargaSocvigRoute,
    ...cargaSocvigPopupRoute,
];

@NgModule({
    imports: [
        DemojhipsterSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        CargaSocvigSapwebComponent,
        CargaSocvigSapwebDetailComponent,
        CargaSocvigSapwebDialogComponent,
        CargaSocvigSapwebDeleteDialogComponent,
        CargaSocvigSapwebPopupComponent,
        CargaSocvigSapwebDeletePopupComponent,
    ],
    entryComponents: [
        CargaSocvigSapwebComponent,
        CargaSocvigSapwebDialogComponent,
        CargaSocvigSapwebPopupComponent,
        CargaSocvigSapwebDeleteDialogComponent,
        CargaSocvigSapwebDeletePopupComponent,
    ],
    providers: [
        CargaSocvigSapwebService,
        CargaSocvigSapwebPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemojhipsterCargaSocvigSapwebModule {}
