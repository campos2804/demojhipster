import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { ModificacionSapweb } from './modificacion-sapweb.model';
import { ModificacionSapwebService } from './modificacion-sapweb.service';

@Injectable()
export class ModificacionSapwebPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private modificacionService: ModificacionSapwebService

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
                this.modificacionService.find(id)
                    .subscribe((modificacionResponse: HttpResponse<ModificacionSapweb>) => {
                        const modificacion: ModificacionSapweb = modificacionResponse.body;
                        if (modificacion.fecescrit) {
                            modificacion.fecescrit = {
                                year: modificacion.fecescrit.getFullYear(),
                                month: modificacion.fecescrit.getMonth() + 1,
                                day: modificacion.fecescrit.getDate()
                            };
                        }
                        if (modificacion.fecact) {
                            modificacion.fecact = {
                                year: modificacion.fecact.getFullYear(),
                                month: modificacion.fecact.getMonth() + 1,
                                day: modificacion.fecact.getDate()
                            };
                        }
                        if (modificacion.fecactnom) {
                            modificacion.fecactnom = {
                                year: modificacion.fecactnom.getFullYear(),
                                month: modificacion.fecactnom.getMonth() + 1,
                                day: modificacion.fecactnom.getDate()
                            };
                        }
                        this.ngbModalRef = this.modificacionModalRef(component, modificacion);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.modificacionModalRef(component, new ModificacionSapweb());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    modificacionModalRef(component: Component, modificacion: ModificacionSapweb): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.modificacion = modificacion;
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
