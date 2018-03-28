import { BaseEntity } from './../../shared';

export class ControlCambioRazonSapweb implements BaseEntity {
    constructor(
        public id?: number,
        public cambioExtracto?: string,
        public cambioRut?: number,
        public cambioDv?: string,
        public cambioEmp?: string,
        public cambioFanta?: string,
        public cambioaEmp?: string,
        public cambioaFanta?: string,
    ) {
    }
}
