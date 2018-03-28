import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { CargaSocvigSapweb } from './carga-socvig-sapweb.model';
import { CargaSocvigSapwebPopupService } from './carga-socvig-sapweb-popup.service';
import { CargaSocvigSapwebService } from './carga-socvig-sapweb.service';

@Component({
    selector: 'jhi-carga-socvig-sapweb-delete-dialog',
    templateUrl: './carga-socvig-sapweb-delete-dialog.component.html'
})
export class CargaSocvigSapwebDeleteDialogComponent {

    cargaSocvig: CargaSocvigSapweb;

    constructor(
        private cargaSocvigService: CargaSocvigSapwebService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.cargaSocvigService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'cargaSocvigListModification',
                content: 'Deleted an cargaSocvig'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-carga-socvig-sapweb-delete-popup',
    template: ''
})
export class CargaSocvigSapwebDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private cargaSocvigPopupService: CargaSocvigSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.cargaSocvigPopupService
                .open(CargaSocvigSapwebDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
