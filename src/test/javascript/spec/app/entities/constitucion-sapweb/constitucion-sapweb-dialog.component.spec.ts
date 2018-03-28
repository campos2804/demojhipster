/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { DemojhipsterTestModule } from '../../../test.module';
import { ConstitucionSapwebDialogComponent } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb-dialog.component';
import { ConstitucionSapwebService } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb.service';
import { ConstitucionSapweb } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb.model';

describe('Component Tests', () => {

    describe('ConstitucionSapweb Management Dialog Component', () => {
        let comp: ConstitucionSapwebDialogComponent;
        let fixture: ComponentFixture<ConstitucionSapwebDialogComponent>;
        let service: ConstitucionSapwebService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [ConstitucionSapwebDialogComponent],
                providers: [
                    ConstitucionSapwebService
                ]
            })
            .overrideTemplate(ConstitucionSapwebDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ConstitucionSapwebDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ConstitucionSapwebService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new ConstitucionSapweb(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.constitucion = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'constitucionListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new ConstitucionSapweb();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.constitucion = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'constitucionListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
