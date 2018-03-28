/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { DemojhipsterTestModule } from '../../../test.module';
import { CargaSocvigSapwebDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb-delete-dialog.component';
import { CargaSocvigSapwebService } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb.service';

describe('Component Tests', () => {

    describe('CargaSocvigSapweb Management Delete Component', () => {
        let comp: CargaSocvigSapwebDeleteDialogComponent;
        let fixture: ComponentFixture<CargaSocvigSapwebDeleteDialogComponent>;
        let service: CargaSocvigSapwebService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [CargaSocvigSapwebDeleteDialogComponent],
                providers: [
                    CargaSocvigSapwebService
                ]
            })
            .overrideTemplate(CargaSocvigSapwebDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(CargaSocvigSapwebDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CargaSocvigSapwebService);
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
