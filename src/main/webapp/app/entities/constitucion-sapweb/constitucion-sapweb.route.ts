import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { ConstitucionSapwebComponent } from './constitucion-sapweb.component';
import { ConstitucionSapwebDetailComponent } from './constitucion-sapweb-detail.component';
import { ConstitucionSapwebPopupComponent } from './constitucion-sapweb-dialog.component';
import { ConstitucionSapwebDeletePopupComponent } from './constitucion-sapweb-delete-dialog.component';

@Injectable()
export class ConstitucionSapwebResolvePagingParams implements Resolve<any> {

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

export const constitucionRoute: Routes = [
    {
        path: 'constitucion-sapweb',
        component: ConstitucionSapwebComponent,
        resolve: {
            'pagingParams': ConstitucionSapwebResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.constitucion.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'constitucion-sapweb/:id',
        component: ConstitucionSapwebDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.constitucion.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const constitucionPopupRoute: Routes = [
    {
        path: 'constitucion-sapweb-new',
        component: ConstitucionSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.constitucion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'constitucion-sapweb/:id/edit',
        component: ConstitucionSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.constitucion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'constitucion-sapweb/:id/delete',
        component: ConstitucionSapwebDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.constitucion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
