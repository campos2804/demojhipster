import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { ConstitucionSapweb } from './constitucion-sapweb.model';
import { ConstitucionSapwebService } from './constitucion-sapweb.service';

@Component({
    selector: 'jhi-constitucion-sapweb-detail',
    templateUrl: './constitucion-sapweb-detail.component.html'
})
export class ConstitucionSapwebDetailComponent implements OnInit, OnDestroy {

    constitucion: ConstitucionSapweb;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private constitucionService: ConstitucionSapwebService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInConstitucions();
    }

    load(id) {
        this.constitucionService.find(id)
            .subscribe((constitucionResponse: HttpResponse<ConstitucionSapweb>) => {
                this.constitucion = constitucionResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInConstitucions() {
        this.eventSubscriber = this.eventManager.subscribe(
            'constitucionListModification',
            (response) => this.load(this.constitucion.id)
        );
    }
}
