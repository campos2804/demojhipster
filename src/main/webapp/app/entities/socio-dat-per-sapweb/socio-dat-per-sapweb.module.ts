import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DemojhipsterSharedModule } from '../../shared';
import {
    SocioDatPerSapwebService,
    SocioDatPerSapwebPopupService,
    SocioDatPerSapwebComponent,
    SocioDatPerSapwebDetailComponent,
    SocioDatPerSapwebDialogComponent,
    SocioDatPerSapwebPopupComponent,
    SocioDatPerSapwebDeletePopupComponent,
    SocioDatPerSapwebDeleteDialogComponent,
    socioDatPerRoute,
    socioDatPerPopupRoute,
} from './';

const ENTITY_STATES = [
    ...socioDatPerRoute,
    ...socioDatPerPopupRoute,
];

@NgModule({
    imports: [
        DemojhipsterSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SocioDatPerSapwebComponent,
        SocioDatPerSapwebDetailComponent,
        SocioDatPerSapwebDialogComponent,
        SocioDatPerSapwebDeleteDialogComponent,
        SocioDatPerSapwebPopupComponent,
        SocioDatPerSapwebDeletePopupComponent,
    ],
    entryComponents: [
        SocioDatPerSapwebComponent,
        SocioDatPerSapwebDialogComponent,
        SocioDatPerSapwebPopupComponent,
        SocioDatPerSapwebDeleteDialogComponent,
        SocioDatPerSapwebDeletePopupComponent,
    ],
    providers: [
        SocioDatPerSapwebService,
        SocioDatPerSapwebPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemojhipsterSocioDatPerSapwebModule {}
