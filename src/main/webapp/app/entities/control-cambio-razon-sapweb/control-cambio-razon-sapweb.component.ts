import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ControlCambioRazonSapweb } from './control-cambio-razon-sapweb.model';
import { ControlCambioRazonSapwebService } from './control-cambio-razon-sapweb.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-control-cambio-razon-sapweb',
    templateUrl: './control-cambio-razon-sapweb.component.html'
})
export class ControlCambioRazonSapwebComponent implements OnInit, OnDestroy {
controlCambioRazons: ControlCambioRazonSapweb[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private controlCambioRazonService: ControlCambioRazonSapwebService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.controlCambioRazonService.query().subscribe(
            (res: HttpResponse<ControlCambioRazonSapweb[]>) => {
                this.controlCambioRazons = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInControlCambioRazons();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ControlCambioRazonSapweb) {
        return item.id;
    }
    registerChangeInControlCambioRazons() {
        this.eventSubscriber = this.eventManager.subscribe('controlCambioRazonListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
