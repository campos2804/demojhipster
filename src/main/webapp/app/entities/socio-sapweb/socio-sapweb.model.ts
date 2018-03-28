import { BaseEntity } from './../../shared';

export class SocioSapweb implements BaseEntity {
    constructor(
        public id?: number,
        public rut?: number,
        public dv?: string,
        public nombre?: string,
        public extracto?: string,
        public aporte?: string,
        public aportePorcen?: number,
        public estado?: number,
        public estadoEs?: number,
        public iden?: number,
    ) {
    }
}
