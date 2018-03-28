import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SocioSapweb } from './socio-sapweb.model';
import { SocioSapwebPopupService } from './socio-sapweb-popup.service';
import { SocioSapwebService } from './socio-sapweb.service';

@Component({
    selector: 'jhi-socio-sapweb-dialog',
    templateUrl: './socio-sapweb-dialog.component.html'
})
export class SocioSapwebDialogComponent implements OnInit {

    socio: SocioSapweb;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private socioService: SocioSapwebService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.socio.id !== undefined) {
            this.subscribeToSaveResponse(
                this.socioService.update(this.socio));
        } else {
            this.subscribeToSaveResponse(
                this.socioService.create(this.socio));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SocioSapweb>>) {
        result.subscribe((res: HttpResponse<SocioSapweb>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SocioSapweb) {
        this.eventManager.broadcast({ name: 'socioListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-socio-sapweb-popup',
    template: ''
})
export class SocioSapwebPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private socioPopupService: SocioSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.socioPopupService
                    .open(SocioSapwebDialogComponent as Component, params['id']);
            } else {
                this.socioPopupService
                    .open(SocioSapwebDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
