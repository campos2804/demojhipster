import { BaseEntity } from './../../shared';

export class ConstitucionSapweb implements BaseEntity {
    constructor(
        public id?: number,
        public rut?: number,
        public dv?: string,
        public extracto?: string,
        public nombre?: string,
        public fecpub?: string,
        public nomfan?: string,
        public feconst?: string,
        public tipconst?: string,
        public duracion?: string,
        public fecterm?: string,
        public cappag?: string,
        public capsus?: string,
        public nacciones?: string,
        public notariorut?: number,
        public notariodv?: string,
        public directorrut?: number,
        public directordv?: string,
        public reprut?: number,
        public repdv?: string,
        public estado?: number,
        public extnomdup?: number,
        public extnomduprut?: number,
        public extnomdupdv?: string,
        public grupo?: number,
        public fecact?: any,
        public fecactnom?: any,
    ) {
    }
}
