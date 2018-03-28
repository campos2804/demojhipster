import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { CargaSocvigSapwebComponent } from './carga-socvig-sapweb.component';
import { CargaSocvigSapwebDetailComponent } from './carga-socvig-sapweb-detail.component';
import { CargaSocvigSapwebPopupComponent } from './carga-socvig-sapweb-dialog.component';
import { CargaSocvigSapwebDeletePopupComponent } from './carga-socvig-sapweb-delete-dialog.component';

export const cargaSocvigRoute: Routes = [
    {
        path: 'carga-socvig-sapweb',
        component: CargaSocvigSapwebComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.cargaSocvig.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'carga-socvig-sapweb/:id',
        component: CargaSocvigSapwebDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.cargaSocvig.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const cargaSocvigPopupRoute: Routes = [
    {
        path: 'carga-socvig-sapweb-new',
        component: CargaSocvigSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.cargaSocvig.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'carga-socvig-sapweb/:id/edit',
        component: CargaSocvigSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.cargaSocvig.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'carga-socvig-sapweb/:id/delete',
        component: CargaSocvigSapwebDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.cargaSocvig.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
