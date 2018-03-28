import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { CargaSocvigSapweb } from './carga-socvig-sapweb.model';
import { CargaSocvigSapwebService } from './carga-socvig-sapweb.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-carga-socvig-sapweb',
    templateUrl: './carga-socvig-sapweb.component.html'
})
export class CargaSocvigSapwebComponent implements OnInit, OnDestroy {
cargaSocvigs: CargaSocvigSapweb[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private cargaSocvigService: CargaSocvigSapwebService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.cargaSocvigService.query().subscribe(
            (res: HttpResponse<CargaSocvigSapweb[]>) => {
                this.cargaSocvigs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInCargaSocvigs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: CargaSocvigSapweb) {
        return item.id;
    }
    registerChangeInCargaSocvigs() {
        this.eventSubscriber = this.eventManager.subscribe('cargaSocvigListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
