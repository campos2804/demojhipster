import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ModificacionSapweb } from './modificacion-sapweb.model';
import { ModificacionSapwebPopupService } from './modificacion-sapweb-popup.service';
import { ModificacionSapwebService } from './modificacion-sapweb.service';

@Component({
    selector: 'jhi-modificacion-sapweb-delete-dialog',
    templateUrl: './modificacion-sapweb-delete-dialog.component.html'
})
export class ModificacionSapwebDeleteDialogComponent {

    modificacion: ModificacionSapweb;

    constructor(
        private modificacionService: ModificacionSapwebService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.modificacionService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'modificacionListModification',
                content: 'Deleted an modificacion'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-modificacion-sapweb-delete-popup',
    template: ''
})
export class ModificacionSapwebDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private modificacionPopupService: ModificacionSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modificacionPopupService
                .open(ModificacionSapwebDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
