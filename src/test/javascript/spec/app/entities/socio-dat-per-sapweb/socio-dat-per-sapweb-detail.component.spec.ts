/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { DemojhipsterTestModule } from '../../../test.module';
import { SocioDatPerSapwebDetailComponent } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb-detail.component';
import { SocioDatPerSapwebService } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb.service';
import { SocioDatPerSapweb } from '../../../../../../main/webapp/app/entities/socio-dat-per-sapweb/socio-dat-per-sapweb.model';

describe('Component Tests', () => {

    describe('SocioDatPerSapweb Management Detail Component', () => {
        let comp: SocioDatPerSapwebDetailComponent;
        let fixture: ComponentFixture<SocioDatPerSapwebDetailComponent>;
        let service: SocioDatPerSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [SocioDatPerSapwebDetailComponent],
                providers: [
                    SocioDatPerSapwebService
                ]
            })
            .overrideTemplate(SocioDatPerSapwebDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SocioDatPerSapwebDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SocioDatPerSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new SocioDatPerSapweb(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.socioDatPer).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
