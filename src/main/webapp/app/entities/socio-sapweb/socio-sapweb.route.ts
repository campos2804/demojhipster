import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { SocioSapwebComponent } from './socio-sapweb.component';
import { SocioSapwebDetailComponent } from './socio-sapweb-detail.component';
import { SocioSapwebPopupComponent } from './socio-sapweb-dialog.component';
import { SocioSapwebDeletePopupComponent } from './socio-sapweb-delete-dialog.component';

export const socioRoute: Routes = [
    {
        path: 'socio-sapweb',
        component: SocioSapwebComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socio.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'socio-sapweb/:id',
        component: SocioSapwebDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socio.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const socioPopupRoute: Routes = [
    {
        path: 'socio-sapweb-new',
        component: SocioSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socio.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'socio-sapweb/:id/edit',
        component: SocioSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socio.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'socio-sapweb/:id/delete',
        component: SocioSapwebDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socio.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
