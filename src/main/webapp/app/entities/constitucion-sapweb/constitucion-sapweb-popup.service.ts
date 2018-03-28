import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { ConstitucionSapweb } from './constitucion-sapweb.model';
import { ConstitucionSapwebService } from './constitucion-sapweb.service';

@Injectable()
export class ConstitucionSapwebPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private constitucionService: ConstitucionSapwebService

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
                this.constitucionService.find(id)
                    .subscribe((constitucionResponse: HttpResponse<ConstitucionSapweb>) => {
                        const constitucion: ConstitucionSapweb = constitucionResponse.body;
                        if (constitucion.fecact) {
                            constitucion.fecact = {
                                year: constitucion.fecact.getFullYear(),
                                month: constitucion.fecact.getMonth() + 1,
                                day: constitucion.fecact.getDate()
                            };
                        }
                        if (constitucion.fecactnom) {
                            constitucion.fecactnom = {
                                year: constitucion.fecactnom.getFullYear(),
                                month: constitucion.fecactnom.getMonth() + 1,
                                day: constitucion.fecactnom.getDate()
                            };
                        }
                        this.ngbModalRef = this.constitucionModalRef(component, constitucion);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.constitucionModalRef(component, new ConstitucionSapweb());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    constitucionModalRef(component: Component, constitucion: ConstitucionSapweb): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.constitucion = constitucion;
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
