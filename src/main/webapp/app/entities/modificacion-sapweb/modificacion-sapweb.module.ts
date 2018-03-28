import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DemojhipsterSharedModule } from '../../shared';
import {
    ModificacionSapwebService,
    ModificacionSapwebPopupService,
    ModificacionSapwebComponent,
    ModificacionSapwebDetailComponent,
    ModificacionSapwebDialogComponent,
    ModificacionSapwebPopupComponent,
    ModificacionSapwebDeletePopupComponent,
    ModificacionSapwebDeleteDialogComponent,
    modificacionRoute,
    modificacionPopupRoute,
    ModificacionSapwebResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...modificacionRoute,
    ...modificacionPopupRoute,
];

@NgModule({
    imports: [
        DemojhipsterSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        ModificacionSapwebComponent,
        ModificacionSapwebDetailComponent,
        ModificacionSapwebDialogComponent,
        ModificacionSapwebDeleteDialogComponent,
        ModificacionSapwebPopupComponent,
        ModificacionSapwebDeletePopupComponent,
    ],
    entryComponents: [
        ModificacionSapwebComponent,
        ModificacionSapwebDialogComponent,
        ModificacionSapwebPopupComponent,
        ModificacionSapwebDeleteDialogComponent,
        ModificacionSapwebDeletePopupComponent,
    ],
    providers: [
        ModificacionSapwebService,
        ModificacionSapwebPopupService,
        ModificacionSapwebResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemojhipsterModificacionSapwebModule {}
