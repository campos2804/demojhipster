import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { CargaSocvigSapweb } from './carga-socvig-sapweb.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<CargaSocvigSapweb>;

@Injectable()
export class CargaSocvigSapwebService {

    private resourceUrl =  SERVER_API_URL + 'api/carga-socvigs';

    constructor(private http: HttpClient) { }

    create(cargaSocvig: CargaSocvigSapweb): Observable<EntityResponseType> {
        const copy = this.convert(cargaSocvig);
        return this.http.post<CargaSocvigSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(cargaSocvig: CargaSocvigSapweb): Observable<EntityResponseType> {
        const copy = this.convert(cargaSocvig);
        return this.http.put<CargaSocvigSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<CargaSocvigSapweb>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<CargaSocvigSapweb[]>> {
        const options = createRequestOption(req);
        return this.http.get<CargaSocvigSapweb[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<CargaSocvigSapweb[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: CargaSocvigSapweb = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<CargaSocvigSapweb[]>): HttpResponse<CargaSocvigSapweb[]> {
        const jsonResponse: CargaSocvigSapweb[] = res.body;
        const body: CargaSocvigSapweb[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to CargaSocvigSapweb.
     */
    private convertItemFromServer(cargaSocvig: CargaSocvigSapweb): CargaSocvigSapweb {
        const copy: CargaSocvigSapweb = Object.assign({}, cargaSocvig);
        return copy;
    }

    /**
     * Convert a CargaSocvigSapweb to a JSON which can be sent to the server.
     */
    private convert(cargaSocvig: CargaSocvigSapweb): CargaSocvigSapweb {
        const copy: CargaSocvigSapweb = Object.assign({}, cargaSocvig);
        return copy;
    }
}
