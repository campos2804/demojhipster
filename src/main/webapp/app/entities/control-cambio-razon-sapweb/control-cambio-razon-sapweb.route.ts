import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { ControlCambioRazonSapwebComponent } from './control-cambio-razon-sapweb.component';
import { ControlCambioRazonSapwebDetailComponent } from './control-cambio-razon-sapweb-detail.component';
import { ControlCambioRazonSapwebPopupComponent } from './control-cambio-razon-sapweb-dialog.component';
import { ControlCambioRazonSapwebDeletePopupComponent } from './control-cambio-razon-sapweb-delete-dialog.component';

export const controlCambioRazonRoute: Routes = [
    {
        path: 'control-cambio-razon-sapweb',
        component: ControlCambioRazonSapwebComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.controlCambioRazon.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'control-cambio-razon-sapweb/:id',
        component: ControlCambioRazonSapwebDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.controlCambioRazon.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const controlCambioRazonPopupRoute: Routes = [
    {
        path: 'control-cambio-razon-sapweb-new',
        component: ControlCambioRazonSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.controlCambioRazon.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'control-cambio-razon-sapweb/:id/edit',
        component: ControlCambioRazonSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.controlCambioRazon.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'control-cambio-razon-sapweb/:id/delete',
        component: ControlCambioRazonSapwebDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.controlCambioRazon.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
