import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DemojhipsterSharedModule } from '../../shared';
import {
    SocioSapwebService,
    SocioSapwebPopupService,
    SocioSapwebComponent,
    SocioSapwebDetailComponent,
    SocioSapwebDialogComponent,
    SocioSapwebPopupComponent,
    SocioSapwebDeletePopupComponent,
    SocioSapwebDeleteDialogComponent,
    socioRoute,
    socioPopupRoute,
} from './';

const ENTITY_STATES = [
    ...socioRoute,
    ...socioPopupRoute,
];

@NgModule({
    imports: [
        DemojhipsterSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SocioSapwebComponent,
        SocioSapwebDetailComponent,
        SocioSapwebDialogComponent,
        SocioSapwebDeleteDialogComponent,
        SocioSapwebPopupComponent,
        SocioSapwebDeletePopupComponent,
    ],
    entryComponents: [
        SocioSapwebComponent,
        SocioSapwebDialogComponent,
        SocioSapwebPopupComponent,
        SocioSapwebDeleteDialogComponent,
        SocioSapwebDeletePopupComponent,
    ],
    providers: [
        SocioSapwebService,
        SocioSapwebPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemojhipsterSocioSapwebModule {}
