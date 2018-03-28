import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { DisolucionSapwebComponent } from './disolucion-sapweb.component';
import { DisolucionSapwebDetailComponent } from './disolucion-sapweb-detail.component';
import { DisolucionSapwebPopupComponent } from './disolucion-sapweb-dialog.component';
import { DisolucionSapwebDeletePopupComponent } from './disolucion-sapweb-delete-dialog.component';

@Injectable()
export class DisolucionSapwebResolvePagingParams implements Resolve<any> {

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

export const disolucionRoute: Routes = [
    {
        path: 'disolucion-sapweb',
        component: DisolucionSapwebComponent,
        resolve: {
            'pagingParams': DisolucionSapwebResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.disolucion.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'disolucion-sapweb/:id',
        component: DisolucionSapwebDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.disolucion.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const disolucionPopupRoute: Routes = [
    {
        path: 'disolucion-sapweb-new',
        component: DisolucionSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.disolucion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'disolucion-sapweb/:id/edit',
        component: DisolucionSapwebPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.disolucion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'disolucion-sapweb/:id/delete',
        component: DisolucionSapwebDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'demojhipsterApp.disolucion.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
