import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { ModificacionSapweb } from './modificacion-sapweb.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<ModificacionSapweb>;

@Injectable()
export class ModificacionSapwebService {

    private resourceUrl =  SERVER_API_URL + 'api/modificacions';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) { }

    create(modificacion: ModificacionSapweb): Observable<EntityResponseType> {
        const copy = this.convert(modificacion);
        return this.http.post<ModificacionSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(modificacion: ModificacionSapweb): Observable<EntityResponseType> {
        const copy = this.convert(modificacion);
        return this.http.put<ModificacionSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ModificacionSapweb>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<ModificacionSapweb[]>> {
        const options = createRequestOption(req);
        return this.http.get<ModificacionSapweb[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<ModificacionSapweb[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: ModificacionSapweb = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<ModificacionSapweb[]>): HttpResponse<ModificacionSapweb[]> {
        const jsonResponse: ModificacionSapweb[] = res.body;
        const body: ModificacionSapweb[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to ModificacionSapweb.
     */
    private convertItemFromServer(modificacion: ModificacionSapweb): ModificacionSapweb {
        const copy: ModificacionSapweb = Object.assign({}, modificacion);
        copy.fecescrit = this.dateUtils
            .convertLocalDateFromServer(modificacion.fecescrit);
        copy.fecact = this.dateUtils
            .convertLocalDateFromServer(modificacion.fecact);
        copy.fecactnom = this.dateUtils
            .convertLocalDateFromServer(modificacion.fecactnom);
        return copy;
    }

    /**
     * Convert a ModificacionSapweb to a JSON which can be sent to the server.
     */
    private convert(modificacion: ModificacionSapweb): ModificacionSapweb {
        const copy: ModificacionSapweb = Object.assign({}, modificacion);
        copy.fecescrit = this.dateUtils
            .convertLocalDateToServer(modificacion.fecescrit);
        copy.fecact = this.dateUtils
            .convertLocalDateToServer(modificacion.fecact);
        copy.fecactnom = this.dateUtils
            .convertLocalDateToServer(modificacion.fecactnom);
        return copy;
    }
}
