import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SocioSapweb } from './socio-sapweb.model';
import { SocioSapwebPopupService } from './socio-sapweb-popup.service';
import { SocioSapwebService } from './socio-sapweb.service';

@Component({
    selector: 'jhi-socio-sapweb-delete-dialog',
    templateUrl: './socio-sapweb-delete-dialog.component.html'
})
export class SocioSapwebDeleteDialogComponent {

    socio: SocioSapweb;

    constructor(
        private socioService: SocioSapwebService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.socioService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'socioListModification',
                content: 'Deleted an socio'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-socio-sapweb-delete-popup',
    template: ''
})
export class SocioSapwebDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private socioPopupService: SocioSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.socioPopupService
                .open(SocioSapwebDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
