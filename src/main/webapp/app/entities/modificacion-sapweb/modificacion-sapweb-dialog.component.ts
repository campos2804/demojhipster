import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ModificacionSapweb } from './modificacion-sapweb.model';
import { ModificacionSapwebPopupService } from './modificacion-sapweb-popup.service';
import { ModificacionSapwebService } from './modificacion-sapweb.service';

@Component({
    selector: 'jhi-modificacion-sapweb-dialog',
    templateUrl: './modificacion-sapweb-dialog.component.html'
})
export class ModificacionSapwebDialogComponent implements OnInit {

    modificacion: ModificacionSapweb;
    isSaving: boolean;
    fecescritDp: any;
    fecactDp: any;
    fecactnomDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private modificacionService: ModificacionSapwebService,
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
        if (this.modificacion.id !== undefined) {
            this.subscribeToSaveResponse(
                this.modificacionService.update(this.modificacion));
        } else {
            this.subscribeToSaveResponse(
                this.modificacionService.create(this.modificacion));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ModificacionSapweb>>) {
        result.subscribe((res: HttpResponse<ModificacionSapweb>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: ModificacionSapweb) {
        this.eventManager.broadcast({ name: 'modificacionListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-modificacion-sapweb-popup',
    template: ''
})
export class ModificacionSapwebPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private modificacionPopupService: ModificacionSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modificacionPopupService
                    .open(ModificacionSapwebDialogComponent as Component, params['id']);
            } else {
                this.modificacionPopupService
                    .open(ModificacionSapwebDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
