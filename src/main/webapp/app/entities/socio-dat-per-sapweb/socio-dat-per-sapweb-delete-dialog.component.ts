import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SocioDatPerSapweb } from './socio-dat-per-sapweb.model';
import { SocioDatPerSapwebPopupService } from './socio-dat-per-sapweb-popup.service';
import { SocioDatPerSapwebService } from './socio-dat-per-sapweb.service';

@Component({
    selector: 'jhi-socio-dat-per-sapweb-delete-dialog',
    templateUrl: './socio-dat-per-sapweb-delete-dialog.component.html'
})
export class SocioDatPerSapwebDeleteDialogComponent {

    socioDatPer: SocioDatPerSapweb;

    constructor(
        private socioDatPerService: SocioDatPerSapwebService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.socioDatPerService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'socioDatPerListModification',
                content: 'Deleted an socioDatPer'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-socio-dat-per-sapweb-delete-popup',
    template: ''
})
export class SocioDatPerSapwebDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private socioDatPerPopupService: SocioDatPerSapwebPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.socioDatPerPopupService
                .open(SocioDatPerSapwebDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
