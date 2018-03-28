/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { DemojhipsterTestModule } from '../../../test.module';
import { SocioSapwebDetailComponent } from '../../../../../../main/webapp/app/entities/socio-sapweb/socio-sapweb-detail.component';
import { SocioSapwebService } from '../../../../../../main/webapp/app/entities/socio-sapweb/socio-sapweb.service';
import { SocioSapweb } from '../../../../../../main/webapp/app/entities/socio-sapweb/socio-sapweb.model';

describe('Component Tests', () => {

    describe('SocioSapweb Management Detail Component', () => {
        let comp: SocioSapwebDetailComponent;
        let fixture: ComponentFixture<SocioSapwebDetailComponent>;
        let service: SocioSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [SocioSapwebDetailComponent],
                providers: [
                    SocioSapwebService
                ]
            })
            .overrideTemplate(SocioSapwebDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SocioSapwebDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SocioSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new SocioSapweb(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.socio).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
