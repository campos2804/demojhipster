/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { DemojhipsterTestModule } from '../../../test.module';
import { DisolucionSapwebDetailComponent } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb-detail.component';
import { DisolucionSapwebService } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb.service';
import { DisolucionSapweb } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb.model';

describe('Component Tests', () => {

    describe('DisolucionSapweb Management Detail Component', () => {
        let comp: DisolucionSapwebDetailComponent;
        let fixture: ComponentFixture<DisolucionSapwebDetailComponent>;
        let service: DisolucionSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [DisolucionSapwebDetailComponent],
                providers: [
                    DisolucionSapwebService
                ]
            })
            .overrideTemplate(DisolucionSapwebDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DisolucionSapwebDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DisolucionSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new DisolucionSapweb(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.disolucion).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
