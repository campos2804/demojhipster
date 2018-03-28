import { BaseEntity } from './../../shared';

export class DisolucionSapweb implements BaseEntity {
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
        public regcom?: string,
        public fojas?: string,
        public num?: string,
        public ano?: string,
        public fecesc?: any,
        public estado?: number,
        public grupo?: number,
        public fecact?: any,
        public fecactnom?: any,
    ) {
    }
}
