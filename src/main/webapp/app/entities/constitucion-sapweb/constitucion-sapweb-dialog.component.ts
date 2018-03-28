import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ConstitucionSapweb } from './constitucion-sapweb.model';
import { ConstitucionSapwebPopupService } from './constitucion-sapweb-popup.service';
import { ConstitucionSapwebService } from './constitucion-sapweb.service';

@Component({
    selector: 'jhi-constitucion-sapweb-dialog',
    templateUrl: './constitucion-sapweb-dialog.component.html'
})
export class ConstitucionSapwebDialogComponent implements OnInit {

    constitucion: ConstitucionSapweb;
    isSaving: boolean;
    fecactDp: any;
    fecactnomDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private constitucionService: ConstitucionSapwebService,
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
        if (this.constitucion.id !== undefined) {
            this.subscribeToSaveResponse(
                this.constitucionService.update(this.constitucion));
        } else {
            this.subscribeToSaveResponse(
                this.constitucionService.create(this.constitucion));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ConstitucionSapweb>>) {
        result.subscribe((res: HttpResponse<ConstitucionSapweb>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: ConstitucionSapweb) {
        this.eventManager.broadcast({ name: 'constitucionListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-constitucion-sapweb-popup',
    template: ''
})
export class ConstitucionSapwebPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private constitucionPopupService: ConstitucionSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.constitucionPopupService
                    .open(ConstitucionSapwebDialogComponent as Component, params['id']);
            } else {
                this.constitucionPopupService
                    .open(ConstitucionSapwebDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
