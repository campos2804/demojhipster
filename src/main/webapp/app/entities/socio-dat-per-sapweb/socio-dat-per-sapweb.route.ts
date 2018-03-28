import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { SocioDatPerSapwebComponent } from './socio-dat-per-sapweb.component';
import { SocioDatPerSapwebDetailComponent } from './socio-dat-per-sapweb-detail.component';
import { SocioDatPerSapwebPopupComponent } from './socio-dat-per-sapweb-dialog.component';
import { SocioDatPerSapwebDeletePopupComponent } from './socio-dat-per-sapweb-delete-dialog.component';

export const socioDatPerRoute: Routes = [
    {
        path: 'socio-dat-per-sapweb',
        component: SocioDatPerSapwebComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socioDatPer.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'socio-dat-per-sapweb/:id',
        component: SocioDatPerSapwebDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socioDatPer.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const socioDatPerPopupRoute: Routes = [
    {
        path: 'socio-dat-per-sapweb-new',
        component: SocioDatPerSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socioDatPer.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'socio-dat-per-sapweb/:id/edit',
        component: SocioDatPerSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socioDatPer.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'socio-dat-per-sapweb/:id/delete',
        component: SocioDatPerSapwebDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.socioDatPer.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
