/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { DemojhipsterTestModule } from '../../../test.module';
import { SocioDatPerSapwebDialogComponent } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb-dialog.component';
import { SocioDatPerSapwebService } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb.service';
import { SocioDatPerSapweb } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb.model';

describe('Component Tests', () => {

    describe('SocioDatPerSapweb Management Dialog Component', () => {
        let comp: SocioDatPerSapwebDialogComponent;
        let fixture: ComponentFixture<SocioDatPerSapwebDialogComponent>;
        let service: SocioDatPerSapwebService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [SocioDatPerSapwebDialogComponent],
                providers: [
                    SocioDatPerSapwebService
                ]
            })
            .overrideTemplate(SocioDatPerSapwebDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SocioDatPerSapwebDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SocioDatPerSapwebService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new SocioDatPerSapweb(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.socioDatPer = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'socioDatPerListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new SocioDatPerSapweb();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.socioDatPer = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'socioDatPerListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
