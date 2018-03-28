import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SocioDatPerSapweb } from './socio-dat-per-sapweb.model';
import { SocioDatPerSapwebService } from './socio-dat-per-sapweb.service';

@Injectable()
export class SocioDatPerSapwebPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private socioDatPerService: SocioDatPerSapwebService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.socioDatPerService.find(id)
                    .subscribe((socioDatPerResponse: HttpResponse<SocioDatPerSapweb>) => {
                        const socioDatPer: SocioDatPerSapweb = socioDatPerResponse.body;
                        this.ngbModalRef = this.socioDatPerModalRef(component, socioDatPer);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.socioDatPerModalRef(component, new SocioDatPerSapweb());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    socioDatPerModalRef(component: Component, socioDatPer: SocioDatPerSapweb): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.socioDatPer = socioDatPer;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
