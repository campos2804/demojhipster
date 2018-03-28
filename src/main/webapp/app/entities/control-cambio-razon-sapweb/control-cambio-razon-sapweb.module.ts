import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DemojhipsterSharedModule } from '../../shared';
import {
    ControlCambioRazonSapwebService,
    ControlCambioRazonSapwebPopupService,
    ControlCambioRazonSapwebComponent,
    ControlCambioRazonSapwebDetailComponent,
    ControlCambioRazonSapwebDialogComponent,
    ControlCambioRazonSapwebPopupComponent,
    ControlCambioRazonSapwebDeletePopupComponent,
    ControlCambioRazonSapwebDeleteDialogComponent,
    controlCambioRazonRoute,
    controlCambioRazonPopupRoute,
} from './';

const ENTITY_STATES = [
    ...controlCambioRazonRoute,
    ...controlCambioRazonPopupRoute,
];

@NgModule({
    imports: [
        DemojhipsterSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        ControlCambioRazonSapwebComponent,
        ControlCambioRazonSapwebDetailComponent,
        ControlCambioRazonSapwebDialogComponent,
        ControlCambioRazonSapwebDeleteDialogComponent,
        ControlCambioRazonSapwebPopupComponent,
        ControlCambioRazonSapwebDeletePopupComponent,
    ],
    entryComponents: [
        ControlCambioRazonSapwebComponent,
        ControlCambioRazonSapwebDialogComponent,
        ControlCambioRazonSapwebPopupComponent,
        ControlCambioRazonSapwebDeleteDialogComponent,
        ControlCambioRazonSapwebDeletePopupComponent,
    ],
    providers: [
        ControlCambioRazonSapwebService,
        ControlCambioRazonSapwebPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemojhipsterControlCambioRazonSapwebModule {}
