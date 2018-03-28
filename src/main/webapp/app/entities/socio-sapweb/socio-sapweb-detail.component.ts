import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SocioSapweb } from './socio-sapweb.model';
import { SocioSapwebService } from './socio-sapweb.service';

@Component({
    selector: 'jhi-socio-sapweb-detail',
    templateUrl: './socio-sapweb-detail.component.html'
})
export class SocioSapwebDetailComponent implements OnInit, OnDestroy {

    socio: SocioSapweb;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private socioService: SocioSapwebService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSocios();
    }

    load(id) {
        this.socioService.find(id)
            .subscribe((socioResponse: HttpResponse<SocioSapweb>) => {
                this.socio = socioResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSocios() {
        this.eventSubscriber = this.eventManager.subscribe(
            'socioListModification',
            (response) => this.load(this.socio.id)
        );
    }
}
