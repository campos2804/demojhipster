import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { SocioDatPerSapweb } from './socio-dat-per-sapweb.model';
import { SocioDatPerSapwebService } from './socio-dat-per-sapweb.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-socio-dat-per-sapweb',
    templateUrl: './socio-dat-per-sapweb.component.html'
})
export class SocioDatPerSapwebComponent implements OnInit, OnDestroy {
socioDatPers: SocioDatPerSapweb[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private socioDatPerService: SocioDatPerSapwebService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.socioDatPerService.query().subscribe(
            (res: HttpResponse<SocioDatPerSapweb[]>) => {
                this.socioDatPers = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInSocioDatPers();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: SocioDatPerSapweb) {
        return item.id;
    }
    registerChangeInSocioDatPers() {
        this.eventSubscriber = this.eventManager.subscribe('socioDatPerListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
