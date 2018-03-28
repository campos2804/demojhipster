import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SocioSapweb } from './socio-sapweb.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SocioSapweb>;

@Injectable()
export class SocioSapwebService {

    private resourceUrl =  SERVER_API_URL + 'api/socios';

    constructor(private http: HttpClient) { }

    create(socio: SocioSapweb): Observable<EntityResponseType> {
        const copy = this.convert(socio);
        return this.http.post<SocioSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(socio: SocioSapweb): Observable<EntityResponseType> {
        const copy = this.convert(socio);
        return this.http.put<SocioSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SocioSapweb>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SocioSapweb[]>> {
        const options = createRequestOption(req);
        return this.http.get<SocioSapweb[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SocioSapweb[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SocioSapweb = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SocioSapweb[]>): HttpResponse<SocioSapweb[]> {
        const jsonResponse: SocioSapweb[] = res.body;
        const body: SocioSapweb[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SocioSapweb.
     */
    private convertItemFromServer(socio: SocioSapweb): SocioSapweb {
        const copy: SocioSapweb = Object.assign({}, socio);
        return copy;
    }

    /**
     * Convert a SocioSapweb to a JSON which can be sent to the server.
     */
    private convert(socio: SocioSapweb): SocioSapweb {
        const copy: SocioSapweb = Object.assign({}, socio);
        return copy;
    }
}
