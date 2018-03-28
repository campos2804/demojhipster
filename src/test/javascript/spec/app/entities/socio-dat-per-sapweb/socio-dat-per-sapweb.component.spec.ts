/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { DemojhipsterTestModule } from '../../../test.module';
import { SocioDatPerSapwebComponent } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb.component';
import { SocioDatPerSapwebService } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb.service';
import { SocioDatPerSapweb } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb.model';

describe('Component Tests', () => {

    describe('SocioDatPerSapweb Management Component', () => {
        let comp: SocioDatPerSapwebComponent;
        let fixture: ComponentFixture<SocioDatPerSapwebComponent>;
        let service: SocioDatPerSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [SocioDatPerSapwebComponent],
                providers: [
                    SocioDatPerSapwebService
                ]
            })
            .overrideTemplate(SocioDatPerSapwebComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SocioDatPerSapwebComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SocioDatPerSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new SocioDatPerSapweb(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.socioDatPers[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
