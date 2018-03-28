/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { DemojhipsterTestModule } from '../../../test.module';
import { CargaSocvigSapwebDialogComponent } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb-dialog.component';
import { CargaSocvigSapwebService } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb.service';
import { CargaSocvigSapweb } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb.model';

describe('Component Tests', () => {

    describe('CargaSocvigSapweb Management Dialog Component', () => {
        let comp: CargaSocvigSapwebDialogComponent;
        let fixture: ComponentFixture<CargaSocvigSapwebDialogComponent>;
        let service: CargaSocvigSapwebService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [CargaSocvigSapwebDialogComponent],
                providers: [
                    CargaSocvigSapwebService
                ]
            })
            .overrideTemplate(CargaSocvigSapwebDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(CargaSocvigSapwebDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CargaSocvigSapwebService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new CargaSocvigSapweb(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.cargaSocvig = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'cargaSocvigListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new CargaSocvigSapweb();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.cargaSocvig = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'cargaSocvigListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
