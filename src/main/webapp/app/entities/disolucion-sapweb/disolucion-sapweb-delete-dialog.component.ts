import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DisolucionSapweb } from './disolucion-sapweb.model';
import { DisolucionSapwebPopupService } from './disolucion-sapweb-popup.service';
import { DisolucionSapwebService } from './disolucion-sapweb.service';

@Component({
    selector: 'jhi-disolucion-sapweb-delete-dialog',
    templateUrl: './disolucion-sapweb-delete-dialog.component.html'
})
export class DisolucionSapwebDeleteDialogComponent {

    disolucion: DisolucionSapweb;

    constructor(
        private disolucionService: DisolucionSapwebService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.disolucionService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'disolucionListModification',
                content: 'Deleted an disolucion'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-disolucion-sapweb-delete-popup',
    template: ''
})
export class DisolucionSapwebDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private disolucionPopupService: DisolucionSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.disolucionPopupService
                .open(DisolucionSapwebDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
