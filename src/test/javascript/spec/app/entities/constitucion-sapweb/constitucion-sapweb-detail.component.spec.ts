/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { DemojhipsterTestModule } from '../../../test.module';
import { ConstitucionSapwebDetailComponent } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb-detail.component';
import { ConstitucionSapwebService } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb.service';
import { ConstitucionSapweb } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb.model';

describe('Component Tests', () => {

    describe('ConstitucionSapweb Management Detail Component', () => {
        let comp: ConstitucionSapwebDetailComponent;
        let fixture: ComponentFixture<ConstitucionSapwebDetailComponent>;
        let service: ConstitucionSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [ConstitucionSapwebDetailComponent],
                providers: [
                    ConstitucionSapwebService
                ]
            })
            .overrideTemplate(ConstitucionSapwebDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ConstitucionSapwebDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ConstitucionSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new ConstitucionSapweb(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.constitucion).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
