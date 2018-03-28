import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SocioDatPerSapweb } from './socio-dat-per-sapweb.model';
import { SocioDatPerSapwebService } from './socio-dat-per-sapweb.service';

@Component({
    selector: 'jhi-socio-dat-per-sapweb-detail',
    templateUrl: './socio-dat-per-sapweb-detail.component.html'
})
export class SocioDatPerSapwebDetailComponent implements OnInit, OnDestroy {

    socioDatPer: SocioDatPerSapweb;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private socioDatPerService: SocioDatPerSapwebService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSocioDatPers();
    }

    load(id) {
        this.socioDatPerService.find(id)
            .subscribe((socioDatPerResponse: HttpResponse<SocioDatPerSapweb>) => {
                this.socioDatPer = socioDatPerResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSocioDatPers() {
        this.eventSubscriber = this.eventManager.subscribe(
            'socioDatPerListModification',
            (response) => this.load(this.socioDatPer.id)
        );
    }
}
