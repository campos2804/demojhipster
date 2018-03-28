import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { DemojhipsterCargaSocvigSapwebModule } from './carga-socvig-sapweb/carga-socvig-sapweb.module';
import { DemojhipsterControlCambioRazonSapwebModule } from './control-cambio-razon-sapweb/control-cambio-razon-sapweb.module';
import { DemojhipsterSocioSapwebModule } from './socio-sapweb/socio-sapweb.module';
import { DemojhipsterSocioDatPerSapwebModule } from './socio-dat-per-sapweb/socio-dat-per-sapweb.module';
import { DemojhipsterConstitucionSapwebModule } from './constitucion-sapweb/constitucion-sapweb.module';
import { DemojhipsterModificacionSapwebModule } from './modificacion-sapweb/modificacion-sapweb.module';
import { DemojhipsterDisolucionSapwebModule } from './disolucion-sapweb/disolucion-sapweb.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        DemojhipsterCargaSocvigSapwebModule,
        DemojhipsterControlCambioRazonSapwebModule,
        DemojhipsterSocioSapwebModule,
        DemojhipsterSocioDatPerSapwebModule,
        DemojhipsterConstitucionSapwebModule,
        DemojhipsterModificacionSapwebModule,
        DemojhipsterDisolucionSapwebModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemojhipsterEntityModule {}
