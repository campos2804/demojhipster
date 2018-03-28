import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SocioDatPerSapweb } from './socio-dat-per-sapweb.model';
import { SocioDatPerSapwebPopupService } from './socio-dat-per-sapweb-popup.service';
import { SocioDatPerSapwebService } from './socio-dat-per-sapweb.service';

@Component({
    selector: 'jhi-socio-dat-per-sapweb-dialog',
    templateUrl: './socio-dat-per-sapweb-dialog.component.html'
})
export class SocioDatPerSapwebDialogComponent implements OnInit {

    socioDatPer: SocioDatPerSapweb;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private socioDatPerService: SocioDatPerSapwebService,
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
        if (this.socioDatPer.id !== undefined) {
            this.subscribeToSaveResponse(
                this.socioDatPerService.update(this.socioDatPer));
        } else {
            this.subscribeToSaveResponse(
                this.socioDatPerService.create(this.socioDatPer));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SocioDatPerSapweb>>) {
        result.subscribe((res: HttpResponse<SocioDatPerSapweb>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SocioDatPerSapweb) {
        this.eventManager.broadcast({ name: 'socioDatPerListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-socio-dat-per-sapweb-popup',
    template: ''
})
export class SocioDatPerSapwebPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private socioDatPerPopupService: SocioDatPerSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.socioDatPerPopupService
                    .open(SocioDatPerSapwebDialogComponent as Component, params['id']);
            } else {
                this.socioDatPerPopupService
                    .open(SocioDatPerSapwebDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
