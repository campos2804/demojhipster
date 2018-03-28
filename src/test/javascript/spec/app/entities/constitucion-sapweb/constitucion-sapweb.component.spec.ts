/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { DemojhipsterTestModule } from '../../../test.module';
import { ConstitucionSapwebComponent } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb.component';
import { ConstitucionSapwebService } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb.service';
import { ConstitucionSapweb } from '../../../../../../main/webapp/app/entities/constitucion-sapweb/constitucion-sapweb.model';

describe('Component Tests', () => {

    describe('ConstitucionSapweb Management Component', () => {
        let comp: ConstitucionSapwebComponent;
        let fixture: ComponentFixture<ConstitucionSapwebComponent>;
        let service: ConstitucionSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [ConstitucionSapwebComponent],
                providers: [
                    ConstitucionSapwebService
                ]
            })
            .overrideTemplate(ConstitucionSapwebComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ConstitucionSapwebComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ConstitucionSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new ConstitucionSapweb(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.constitucions[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
