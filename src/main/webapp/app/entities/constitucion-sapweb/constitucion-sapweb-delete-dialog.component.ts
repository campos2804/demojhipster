import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ConstitucionSapweb } from './constitucion-sapweb.model';
import { ConstitucionSapwebPopupService } from './constitucion-sapweb-popup.service';
import { ConstitucionSapwebService } from './constitucion-sapweb.service';

@Component({
    selector: 'jhi-constitucion-sapweb-delete-dialog',
    templateUrl: './constitucion-sapweb-delete-dialog.component.html'
})
export class ConstitucionSapwebDeleteDialogComponent {

    constitucion: ConstitucionSapweb;

    constructor(
        private constitucionService: ConstitucionSapwebService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.constitucionService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'constitucionListModification',
                content: 'Deleted an constitucion'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-constitucion-sapweb-delete-popup',
    template: ''
})
export class ConstitucionSapwebDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private constitucionPopupService: ConstitucionSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.constitucionPopupService
                .open(ConstitucionSapwebDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
