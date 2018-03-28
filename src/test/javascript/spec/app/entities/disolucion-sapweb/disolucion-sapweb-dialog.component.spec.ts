/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { DemojhipsterTestModule } from '../../../test.module';
import { DisolucionSapwebDialogComponent } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb-dialog.component';
import { DisolucionSapwebService } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb.service';
import { DisolucionSapweb } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb.model';

describe('Component Tests', () => {

    describe('DisolucionSapweb Management Dialog Component', () => {
        let comp: DisolucionSapwebDialogComponent;
        let fixture: ComponentFixture<DisolucionSapwebDialogComponent>;
        let service: DisolucionSapwebService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [DisolucionSapwebDialogComponent],
                providers: [
                    DisolucionSapwebService
                ]
            })
            .overrideTemplate(DisolucionSapwebDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DisolucionSapwebDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DisolucionSapwebService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new DisolucionSapweb(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.disolucion = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'disolucionListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new DisolucionSapweb();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.disolucion = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'disolucionListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
