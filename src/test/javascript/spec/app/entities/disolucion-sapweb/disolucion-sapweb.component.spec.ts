/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { DemojhipsterTestModule } from '../../../test.module';
import { DisolucionSapwebComponent } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb.component';
import { DisolucionSapwebService } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb.service';
import { DisolucionSapweb } from '../../../../../../main/webapp/app/entities/disolucion-sapweb/disolucion-sapweb.model';

describe('Component Tests', () => {

    describe('DisolucionSapweb Management Component', () => {
        let comp: DisolucionSapwebComponent;
        let fixture: ComponentFixture<DisolucionSapwebComponent>;
        let service: DisolucionSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [DisolucionSapwebComponent],
                providers: [
                    DisolucionSapwebService
                ]
            })
            .overrideTemplate(DisolucionSapwebComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DisolucionSapwebComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DisolucionSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new DisolucionSapweb(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.disolucions[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
