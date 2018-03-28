/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { DemojhipsterTestModule } from '../../../test.module';
import { DisolucionSapwebDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb-delete-dialog.component';
import { DisolucionSapwebService } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb.service';

describe('Component Tests', () => {

    describe('DisolucionSapweb Management Delete Component', () => {
        let comp: DisolucionSapwebDeleteDialogComponent;
        let fixture: ComponentFixture<DisolucionSapwebDeleteDialogComponent>;
        let service: DisolucionSapwebService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [DisolucionSapwebDeleteDialogComponent],
                providers: [
                    DisolucionSapwebService
                ]
            })
            .overrideTemplate(DisolucionSapwebDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DisolucionSapwebDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DisolucionSapwebService);
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
