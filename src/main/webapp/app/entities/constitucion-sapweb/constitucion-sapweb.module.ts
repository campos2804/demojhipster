import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DemojhipsterSharedModule } from '../../shared';
import {
    ConstitucionSapwebService,
    ConstitucionSapwebPopupService,
    ConstitucionSapwebComponent,
    ConstitucionSapwebDetailComponent,
    ConstitucionSapwebDialogComponent,
    ConstitucionSapwebPopupComponent,
    ConstitucionSapwebDeletePopupComponent,
    ConstitucionSapwebDeleteDialogComponent,
    constitucionRoute,
    constitucionPopupRoute,
    ConstitucionSapwebResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...constitucionRoute,
    ...constitucionPopupRoute,
];

@NgModule({
    imports: [
        DemojhipsterSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        ConstitucionSapwebComponent,
        ConstitucionSapwebDetailComponent,
        ConstitucionSapwebDialogComponent,
        ConstitucionSapwebDeleteDialogComponent,
        ConstitucionSapwebPopupComponent,
        ConstitucionSapwebDeletePopupComponent,
    ],
    entryComponents: [
        ConstitucionSapwebComponent,
        ConstitucionSapwebDialogComponent,
        ConstitucionSapwebPopupComponent,
        ConstitucionSapwebDeleteDialogComponent,
        ConstitucionSapwebDeletePopupComponent,
    ],
    providers: [
        ConstitucionSapwebService,
        ConstitucionSapwebPopupService,
        ConstitucionSapwebResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemojhipsterConstitucionSapwebModule {}
