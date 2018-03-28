import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { ModificacionSapweb } from './modificacion-sapweb.model';
import { ModificacionSapwebService } from './modificacion-sapweb.service';

@Component({
    selector: 'jhi-modificacion-sapweb-detail',
    templateUrl: './modificacion-sapweb-detail.component.html'
})
export class ModificacionSapwebDetailComponent implements OnInit, OnDestroy {

    modificacion: ModificacionSapweb;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private modificacionService: ModificacionSapwebService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInModificacions();
    }

    load(id) {
        this.modificacionService.find(id)
            .subscribe((modificacionResponse: HttpResponse<ModificacionSapweb>) => {
                this.modificacion = modificacionResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInModificacions() {
        this.eventSubscriber = this.eventManager.subscribe(
            'modificacionListModification',
            (response) => this.load(this.modificacion.id)
        );
    }
}
