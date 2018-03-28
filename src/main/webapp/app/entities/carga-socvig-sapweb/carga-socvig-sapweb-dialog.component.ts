import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { CargaSocvigSapweb } from './carga-socvig-sapweb.model';
import { CargaSocvigSapwebPopupService } from './carga-socvig-sapweb-popup.service';
import { CargaSocvigSapwebService } from './carga-socvig-sapweb.service';

@Component({
    selector: 'jhi-carga-socvig-sapweb-dialog',
    templateUrl: './carga-socvig-sapweb-dialog.component.html'
})
export class CargaSocvigSapwebDialogComponent implements OnInit {

    cargaSocvig: CargaSocvigSapweb;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private cargaSocvigService: CargaSocvigSapwebService,
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
        if (this.cargaSocvig.id !== undefined) {
            this.subscribeToSaveResponse(
                this.cargaSocvigService.update(this.cargaSocvig));
        } else {
            this.subscribeToSaveResponse(
                this.cargaSocvigService.create(this.cargaSocvig));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<CargaSocvigSapweb>>) {
        result.subscribe((res: HttpResponse<CargaSocvigSapweb>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: CargaSocvigSapweb) {
        this.eventManager.broadcast({ name: 'cargaSocvigListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-carga-socvig-sapweb-popup',
    template: ''
})
export class CargaSocvigSapwebPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private cargaSocvigPopupService: CargaSocvigSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.cargaSocvigPopupService
                    .open(CargaSocvigSapwebDialogComponent as Component, params['id']);
            } else {
                this.cargaSocvigPopupService
                    .open(CargaSocvigSapwebDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
