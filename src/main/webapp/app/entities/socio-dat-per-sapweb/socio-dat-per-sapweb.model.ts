import { BaseEntity } from './../../shared';

export class SocioDatPerSapweb implements BaseEntity {
    constructor(
        public id?: number,
        public iden?: number,
        public profesion?: string,
        public direccion?: string,
        public comuna?: string,
        public ciudad?: string,
        public region?: number,
    ) {
    }
}
