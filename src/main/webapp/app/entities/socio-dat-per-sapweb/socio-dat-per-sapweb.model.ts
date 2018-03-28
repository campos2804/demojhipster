import { BaseEntity } from './../../shared';

export class SocioDatPerSapweb implements BaseEntity {
    constructor(
        public id?: number,
        public corrControl?: number,
        public usuarioId?: string,
        public extracto?: string,
        public fechaActiva?: any,
        public fechaTermina?: any,
    ) {
    }
}
