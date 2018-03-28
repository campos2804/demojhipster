import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { ModificacionSapwebComponent } from './modificacion-sapweb.component';
import { ModificacionSapwebDetailComponent } from './modificacion-sapweb-detail.component';
import { ModificacionSapwebPopupComponent } from './modificacion-sapweb-dialog.component';
import { ModificacionSapwebDeletePopupComponent } from './modificacion-sapweb-delete-dialog.component';

@Injectable()
export class ModificacionSapwebResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const modificacionRoute: Routes = [
    {
        path: 'modificacion-sapweb',
        component: ModificacionSapwebComponent,
        resolve: {
            'pagingParams': ModificacionSapwebResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.modificacion.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'modificacion-sapweb/:id',
        component: ModificacionSapwebDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.modificacion.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const modificacionPopupRoute: Routes = [
    {
        path: 'modificacion-sapweb-new',
        component: ModificacionSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.modificacion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'modificacion-sapweb/:id/edit',
        component: ModificacionSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.modificacion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'modificacion-sapweb/:id/delete',
        component: ModificacionSapwebDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.modificacion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
