import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DisolucionSapweb } from './disolucion-sapweb.model';
import { DisolucionSapwebPopupService } from './disolucion-sapweb-popup.service';
import { DisolucionSapwebService } from './disolucion-sapweb.service';

@Component({
    selector: 'jhi-disolucion-sapweb-dialog',
    templateUrl: './disolucion-sapweb-dialog.component.html'
})
export class DisolucionSapwebDialogComponent implements OnInit {

    disolucion: DisolucionSapweb;
    isSaving: boolean;
    fecescDp: any;
    fecactDp: any;
    fecactnomDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private disolucionService: DisolucionSapwebService,
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
        if (this.disolucion.id !== undefined) {
            this.subscribeToSaveResponse(
                this.disolucionService.update(this.disolucion));
        } else {
            this.subscribeToSaveResponse(
                this.disolucionService.create(this.disolucion));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<DisolucionSapweb>>) {
        result.subscribe((res: HttpResponse<DisolucionSapweb>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: DisolucionSapweb) {
        this.eventManager.broadcast({ name: 'disolucionListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-disolucion-sapweb-popup',
    template: ''
})
export class DisolucionSapwebPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private disolucionPopupService: DisolucionSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.disolucionPopupService
                    .open(DisolucionSapwebDialogComponent as Component, params['id']);
            } else {
                this.disolucionPopupService
                    .open(DisolucionSapwebDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
