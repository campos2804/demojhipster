/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { DemojhipsterTestModule } from '../../../test.module';
import { ModificacionSapwebDetailComponent } from '../../../../../../main/webapp/app/entities/modificacion-sapweb/modificacion-sapweb-detail.component';
import { ModificacionSapwebService } from '../../../../../../main/webapp/app/entities/modificacion-sapweb/modificacion-sapweb.service';
import { ModificacionSapweb } from '../../../../../../main/webapp/app/entities/modificacion-sapweb/modificacion-sapweb.model';

describe('Component Tests', () => {

    describe('ModificacionSapweb Management Detail Component', () => {
        let comp: ModificacionSapwebDetailComponent;
        let fixture: ComponentFixture<ModificacionSapwebDetailComponent>;
        let service: ModificacionSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [DemojhipsterTestModule],
                declarations: [ModificacionSapwebDetailComponent],
                providers: [
                    ModificacionSapwebService
                ]
            })
            .overrideTemplate(ModificacionSapwebDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ModificacionSapwebDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ModificacionSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new ModificacionSapweb(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.modificacion).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
