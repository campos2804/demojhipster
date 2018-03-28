import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ControlCambioRazonSapweb } from './control-cambio-razon-sapweb.model';
import { ControlCambioRazonSapwebPopupService } from './control-cambio-razon-sapweb-popup.service';
import { ControlCambioRazonSapwebService } from './control-cambio-razon-sapweb.service';

@Component({
    selector: 'jhi-control-cambio-razon-sapweb-dialog',
    templateUrl: './control-cambio-razon-sapweb-dialog.component.html'
})
export class ControlCambioRazonSapwebDialogComponent implements OnInit {

    controlCambioRazon: ControlCambioRazonSapweb;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private controlCambioRazonService: ControlCambioRazonSapwebService,
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
        if (this.controlCambioRazon.id !== undefined) {
            this.subscribeToSaveResponse(
                this.controlCambioRazonService.update(this.controlCambioRazon));
        } else {
            this.subscribeToSaveResponse(
                this.controlCambioRazonService.create(this.controlCambioRazon));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ControlCambioRazonSapweb>>) {
        result.subscribe((res: HttpResponse<ControlCambioRazonSapweb>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: ControlCambioRazonSapweb) {
        this.eventManager.broadcast({ name: 'controlCambioRazonListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-control-cambio-razon-sapweb-popup',
    template: ''
})
export class ControlCambioRazonSapwebPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private controlCambioRazonPopupService: ControlCambioRazonSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.controlCambioRazonPopupService
                    .open(ControlCambioRazonSapwebDialogComponent as Component, params['id']);
            } else {
                this.controlCambioRazonPopupService
                    .open(ControlCambioRazonSapwebDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
