/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { DemojhipsterTestModule } from '../../../test.module';
import { ControlCambioRazonSapwebComponent } from '../../../../../../main/webapp/app/entities/control-cambio-razon-sapweb/control-cambio-razon-sapweb.component';
import { ControlCambioRazonSapwebService } from '../../../../../../main/webapp/app/entities/control-cambio-razon-sapweb/control-cambio-razon-sapweb.service';
import { ControlCambioRazonSapweb } from '../../../../../../main/webapp/app/entities/control-cambio-razon-sapweb/control-cambio-razon-sapweb.model';

describe('Component Tests', () => {

    describe('ControlCambioRazonSapweb Management Component', () => {
        let comp: ControlCambioRazonSapwebComponent;
        let fixture: ComponentFixture<ControlCambioRazonSapwebComponent>;
        let service: ControlCambioRazonSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [ControlCambioRazonSapwebComponent],
                providers: [
                    ControlCambioRazonSapwebService
                ]
            })
            .overrideTemplate(ControlCambioRazonSapwebComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ControlCambioRazonSapwebComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ControlCambioRazonSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new ControlCambioRazonSapweb(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.controlCambioRazons[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
