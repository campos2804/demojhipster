/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { DemojhipsterTestModule } from '../../../test.module';
import { ControlCambioRazonSapwebDetailComponent } from '../../../../../../main/webapp/app/entities/control-cambio-razon-sapweb/control-cambio-razon-sapweb-detail.component';
import { ControlCambioRazonSapwebService } from '../../../../../../main/webapp/app/entities/control-cambio-razon-sapweb/control-cambio-razon-sapweb.service';
import { ControlCambioRazonSapweb } from '../../../../../../main/webapp/app/entities/control-cambio-razon-sapweb/control-cambio-razon-sapweb.model';

describe('Component Tests', () => {

    describe('ControlCambioRazonSapweb Management Detail Component', () => {
        let comp: ControlCambioRazonSapwebDetailComponent;
        let fixture: ComponentFixture<ControlCambioRazonSapwebDetailComponent>;
        let service: ControlCambioRazonSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [ControlCambioRazonSapwebDetailComponent],
                providers: [
                    ControlCambioRazonSapwebService
                ]
            })
            .overrideTemplate(ControlCambioRazonSapwebDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ControlCambioRazonSapwebDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ControlCambioRazonSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new ControlCambioRazonSapweb(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.controlCambioRazon).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
