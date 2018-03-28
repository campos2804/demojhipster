import { BaseEntity } from './../../shared';

export class CargaSocvigSapweb implements BaseEntity {
    constructor(
        public id?: number,
        public rut?: number,
        public dv?: string,
        public nivel?: number,
    ) {
    }
}
