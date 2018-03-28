import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { ControlCambioRazonSapweb } from './control-cambio-razon-sapweb.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<ControlCambioRazonSapweb>;

@Injectable()
export class ControlCambioRazonSapwebService {

    private resourceUrl =  SERVER_API_URL + 'api/control-cambio-razons';

    constructor(private http: HttpClient) { }

    create(controlCambioRazon: ControlCambioRazonSapweb): Observable<EntityResponseType> {
        const copy = this.convert(controlCambioRazon);
        return this.http.post<ControlCambioRazonSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(controlCambioRazon: ControlCambioRazonSapweb): Observable<EntityResponseType> {
        const copy = this.convert(controlCambioRazon);
        return this.http.put<ControlCambioRazonSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ControlCambioRazonSapweb>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<ControlCambioRazonSapweb[]>> {
        const options = createRequestOption(req);
        return this.http.get<ControlCambioRazonSapweb[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<ControlCambioRazonSapweb[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: ControlCambioRazonSapweb = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<ControlCambioRazonSapweb[]>): HttpResponse<ControlCambioRazonSapweb[]> {
        const jsonResponse: ControlCambioRazonSapweb[] = res.body;
        const body: ControlCambioRazonSapweb[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to ControlCambioRazonSapweb.
     */
    private convertItemFromServer(controlCambioRazon: ControlCambioRazonSapweb): ControlCambioRazonSapweb {
        const copy: ControlCambioRazonSapweb = Object.assign({}, controlCambioRazon);
        return copy;
    }

    /**
     * Convert a ControlCambioRazonSapweb to a JSON which can be sent to the server.
     */
    private convert(controlCambioRazon: ControlCambioRazonSapweb): ControlCambioRazonSapweb {
        const copy: ControlCambioRazonSapweb = Object.assign({}, controlCambioRazon);
        return copy;
    }
}
