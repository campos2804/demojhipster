/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { DemojhipsterTestModule } from '../../../test.module';
import { SocioDatPerSapwebDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb-delete-dialog.component';
import { SocioDatPerSapwebService } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb.service';

describe('Component Tests', () => {

    describe('SocioDatPerSapweb Management Delete Component', () => {
        let comp: SocioDatPerSapwebDeleteDialogComponent;
        let fixture: ComponentFixture<SocioDatPerSapwebDeleteDialogComponent>;
        let service: SocioDatPerSapwebService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [SocioDatPerSapwebDeleteDialogComponent],
                providers: [
                    SocioDatPerSapwebService
                ]
            })
            .overrideTemplate(SocioDatPerSapwebDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SocioDatPerSapwebDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SocioDatPerSapwebService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
