/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { DemojhipsterTestModule } from '../../../test.module';
import { ModificacionSapwebComponent } from '../../../../../../main/webapp/app/entities/modificacion-sapweb/modificacion-sapweb.component';
import { ModificacionSapwebService } from '../../../../../../main/webapp/app/entities/modificacion-sapweb/modificacion-sapweb.service';
import { ModificacionSapweb } from '../../../../../../main/webapp/app/entities/modificacion-sapweb/modificacion-sapweb.model';

describe('Component Tests', () => {

    describe('ModificacionSapweb Management Component', () => {
        let comp: ModificacionSapwebComponent;
        let fixture: ComponentFixture<ModificacionSapwebComponent>;
        let service: ModificacionSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [ModificacionSapwebComponent],
                providers: [
                    ModificacionSapwebService
                ]
            })
            .overrideTemplate(ModificacionSapwebComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ModificacionSapwebComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ModificacionSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new ModificacionSapweb(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.modificacions[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
