import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { DisolucionSapweb } from './disolucion-sapweb.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<DisolucionSapweb>;

@Injectable()
export class DisolucionSapwebService {

    private resourceUrl =  SERVER_API_URL + 'api/disolucions';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) { }

    create(disolucion: DisolucionSapweb): Observable<EntityResponseType> {
        const copy = this.convert(disolucion);
        return this.http.post<DisolucionSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(disolucion: DisolucionSapweb): Observable<EntityResponseType> {
        const copy = this.convert(disolucion);
        return this.http.put<DisolucionSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<DisolucionSapweb>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<DisolucionSapweb[]>> {
        const options = createRequestOption(req);
        return this.http.get<DisolucionSapweb[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<DisolucionSapweb[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: DisolucionSapweb = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<DisolucionSapweb[]>): HttpResponse<DisolucionSapweb[]> {
        const jsonResponse: DisolucionSapweb[] = res.body;
        const body: DisolucionSapweb[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to DisolucionSapweb.
     */
    private convertItemFromServer(disolucion: DisolucionSapweb): DisolucionSapweb {
        const copy: DisolucionSapweb = Object.assign({}, disolucion);
        copy.fecesc = this.dateUtils
            .convertLocalDateFromServer(disolucion.fecesc);
        copy.fecact = this.dateUtils
            .convertLocalDateFromServer(disolucion.fecact);
        copy.fecactnom = this.dateUtils
            .convertLocalDateFromServer(disolucion.fecactnom);
        return copy;
    }

    /**
     * Convert a DisolucionSapweb to a JSON which can be sent to the server.
     */
    private convert(disolucion: DisolucionSapweb): DisolucionSapweb {
        const copy: DisolucionSapweb = Object.assign({}, disolucion);
        copy.fecesc = this.dateUtils
            .convertLocalDateToServer(disolucion.fecesc);
        copy.fecact = this.dateUtils
            .convertLocalDateToServer(disolucion.fecact);
        copy.fecactnom = this.dateUtils
            .convertLocalDateToServer(disolucion.fecactnom);
        return copy;
    }
}
