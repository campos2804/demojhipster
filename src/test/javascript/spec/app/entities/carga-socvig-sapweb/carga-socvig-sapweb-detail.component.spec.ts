/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { DemojhipsterTestModule } from '../../../test.module';
import { CargaSocvigSapwebDetailComponent } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb-detail.component';
import { CargaSocvigSapwebService } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb.service';
import { CargaSocvigSapweb } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb.model';

describe('Component Tests', () => {

    describe('CargaSocvigSapweb Management Detail Component', () => {
        let comp: CargaSocvigSapwebDetailComponent;
        let fixture: ComponentFixture<CargaSocvigSapwebDetailComponent>;
        let service: CargaSocvigSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [CargaSocvigSapwebDetailComponent],
                providers: [
                    CargaSocvigSapwebService
                ]
            })
            .overrideTemplate(CargaSocvigSapwebDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(CargaSocvigSapwebDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CargaSocvigSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new CargaSocvigSapweb(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.cargaSocvig).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
