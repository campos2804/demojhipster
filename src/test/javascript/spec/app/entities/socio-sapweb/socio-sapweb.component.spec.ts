/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { DemojhipsterTestModule } from '../../../test.module';
import { SocioSapwebComponent } from '../../../../../../main/webapp/app/entities/socio-sapweb/socio-sapweb.component';
import { SocioSapwebService } from '../../../../../../main/webapp/app/entities/socio-sapweb/socio-sapweb.service';
import { SocioSapweb } from '../../../../../../main/webapp/app/entities/socio-sapweb/socio-sapweb.model';

describe('Component Tests', () => {

    describe('SocioSapweb Management Component', () => {
        let comp: SocioSapwebComponent;
        let fixture: ComponentFixture<SocioSapwebComponent>;
        let service: SocioSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [SocioSapwebComponent],
                providers: [
                    SocioSapwebService
                ]
            })
            .overrideTemplate(SocioSapwebComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SocioSapwebComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SocioSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new SocioSapweb(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.socios[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
