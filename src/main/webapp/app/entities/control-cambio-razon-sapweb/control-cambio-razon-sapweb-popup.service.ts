import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { ControlCambioRazonSapweb } from './control-cambio-razon-sapweb.model';
import { ControlCambioRazonSapwebService } from './control-cambio-razon-sapweb.service';

@Injectable()
export class ControlCambioRazonSapwebPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private controlCambioRazonService: ControlCambioRazonSapwebService

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
                this.controlCambioRazonService.find(id)
                    .subscribe((controlCambioRazonResponse: HttpResponse<ControlCambioRazonSapweb>) => {
                        const controlCambioRazon: ControlCambioRazonSapweb = controlCambioRazonResponse.body;
                        this.ngbModalRef = this.controlCambioRazonModalRef(component, controlCambioRazon);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.controlCambioRazonModalRef(component, new ControlCambioRazonSapweb());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    controlCambioRazonModalRef(component: Component, controlCambioRazon: ControlCambioRazonSapweb): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.controlCambioRazon = controlCambioRazon;
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
