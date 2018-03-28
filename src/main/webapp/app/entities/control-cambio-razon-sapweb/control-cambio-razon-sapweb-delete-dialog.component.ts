import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ControlCambioRazonSapweb } from './control-cambio-razon-sapweb.model';
import { ControlCambioRazonSapwebPopupService } from './control-cambio-razon-sapweb-popup.service';
import { ControlCambioRazonSapwebService } from './control-cambio-razon-sapweb.service';

@Component({
    selector: 'jhi-control-cambio-razon-sapweb-delete-dialog',
    templateUrl: './control-cambio-razon-sapweb-delete-dialog.component.html'
})
export class ControlCambioRazonSapwebDeleteDialogComponent {

    controlCambioRazon: ControlCambioRazonSapweb;

    constructor(
        private controlCambioRazonService: ControlCambioRazonSapwebService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.controlCambioRazonService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'controlCambioRazonListModification',
                content: 'Deleted an controlCambioRazon'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-control-cambio-razon-sapweb-delete-popup',
    template: ''
})
export class ControlCambioRazonSapwebDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private controlCambioRazonPopupService: ControlCambioRazonSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.controlCambioRazonPopupService
                .open(ControlCambioRazonSapwebDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
