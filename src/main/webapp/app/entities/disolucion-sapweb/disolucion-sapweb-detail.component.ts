import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { DisolucionSapweb } from './disolucion-sapweb.model';
import { DisolucionSapwebService } from './disolucion-sapweb.service';

@Component({
    selector: 'jhi-disolucion-sapweb-detail',
    templateUrl: './disolucion-sapweb-detail.component.html'
})
export class DisolucionSapwebDetailComponent implements OnInit, OnDestroy {

    disolucion: DisolucionSapweb;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private disolucionService: DisolucionSapwebService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDisolucions();
    }

    load(id) {
        this.disolucionService.find(id)
            .subscribe((disolucionResponse: HttpResponse<DisolucionSapweb>) => {
                this.disolucion = disolucionResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDisolucions() {
        this.eventSubscriber = this.eventManager.subscribe(
            'disolucionListModification',
            (response) => this.load(this.disolucion.id)
        );
    }
}
