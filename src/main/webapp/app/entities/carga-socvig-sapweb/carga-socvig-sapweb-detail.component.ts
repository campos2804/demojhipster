import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { CargaSocvigSapweb } from './carga-socvig-sapweb.model';
import { CargaSocvigSapwebService } from './carga-socvig-sapweb.service';

@Component({
    selector: 'jhi-carga-socvig-sapweb-detail',
    templateUrl: './carga-socvig-sapweb-detail.component.html'
})
export class CargaSocvigSapwebDetailComponent implements OnInit, OnDestroy {

    cargaSocvig: CargaSocvigSapweb;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private cargaSocvigService: CargaSocvigSapwebService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInCargaSocvigs();
    }

    load(id) {
        this.cargaSocvigService.find(id)
            .subscribe((cargaSocvigResponse: HttpResponse<CargaSocvigSapweb>) => {
                this.cargaSocvig = cargaSocvigResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInCargaSocvigs() {
        this.eventSubscriber = this.eventManager.subscribe(
            'cargaSocvigListModification',
            (response) => this.load(this.cargaSocvig.id)
        );
    }
}
