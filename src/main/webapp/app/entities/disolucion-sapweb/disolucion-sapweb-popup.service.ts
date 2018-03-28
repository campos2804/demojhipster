import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { DisolucionSapweb } from './disolucion-sapweb.model';
import { DisolucionSapwebService } from './disolucion-sapweb.service';

@Injectable()
export class DisolucionSapwebPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private disolucionService: DisolucionSapwebService

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
                this.disolucionService.find(id)
                    .subscribe((disolucionResponse: HttpResponse<DisolucionSapweb>) => {
                        const disolucion: DisolucionSapweb = disolucionResponse.body;
                        if (disolucion.fecesc) {
                            disolucion.fecesc = {
                                year: disolucion.fecesc.getFullYear(),
                                month: disolucion.fecesc.getMonth() + 1,
                                day: disolucion.fecesc.getDate()
                            };
                        }
                        if (disolucion.fecact) {
                            disolucion.fecact = {
                                year: disolucion.fecact.getFullYear(),
                                month: disolucion.fecact.getMonth() + 1,
                                day: disolucion.fecact.getDate()
                            };
                        }
                        if (disolucion.fecactnom) {
                            disolucion.fecactnom = {
                                year: disolucion.fecactnom.getFullYear(),
                                month: disolucion.fecactnom.getMonth() + 1,
                                day: disolucion.fecactnom.getDate()
                            };
                        }
                        this.ngbModalRef = this.disolucionModalRef(component, disolucion);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.disolucionModalRef(component, new DisolucionSapweb());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    disolucionModalRef(component: Component, disolucion: DisolucionSapweb): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.disolucion = disolucion;
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
