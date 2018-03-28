import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { ControlCambioRazonSapweb } from './control-cambio-razon-sapweb.model';
import { ControlCambioRazonSapwebService } from './control-cambio-razon-sapweb.service';

@Component({
    selector: 'jhi-control-cambio-razon-sapweb-detail',
    templateUrl: './control-cambio-razon-sapweb-detail.component.html'
})
export class ControlCambioRazonSapwebDetailComponent implements OnInit, OnDestroy {

    controlCambioRazon: ControlCambioRazonSapweb;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private controlCambioRazonService: ControlCambioRazonSapwebService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInControlCambioRazons();
    }

    load(id) {
        this.controlCambioRazonService.find(id)
            .subscribe((controlCambioRazonResponse: HttpResponse<ControlCambioRazonSapweb>) => {
                this.controlCambioRazon = controlCambioRazonResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInControlCambioRazons() {
        this.eventSubscriber = this.eventManager.subscribe(
            'controlCambioRazonListModification',
            (response) => this.load(this.controlCambioRazon.id)
        );
    }
}
