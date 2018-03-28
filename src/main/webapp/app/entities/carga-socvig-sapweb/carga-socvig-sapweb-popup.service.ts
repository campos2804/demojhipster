import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { CargaSocvigSapweb } from './carga-socvig-sapweb.model';
import { CargaSocvigSapwebService } from './carga-socvig-sapweb.service';

@Injectable()
export class CargaSocvigSapwebPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private cargaSocvigService: CargaSocvigSapwebService

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
                this.cargaSocvigService.find(id)
                    .subscribe((cargaSocvigResponse: HttpResponse<CargaSocvigSapweb>) => {
                        const cargaSocvig: CargaSocvigSapweb = cargaSocvigResponse.body;
                        this.ngbModalRef = this.cargaSocvigModalRef(component, cargaSocvig);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.cargaSocvigModalRef(component, new CargaSocvigSapweb());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    cargaSocvigModalRef(component: Component, cargaSocvig: CargaSocvigSapweb): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.cargaSocvig = cargaSocvig;
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
