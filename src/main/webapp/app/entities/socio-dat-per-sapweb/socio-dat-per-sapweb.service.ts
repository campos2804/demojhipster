import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SocioDatPerSapweb } from './socio-dat-per-sapweb.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SocioDatPerSapweb>;

@Injectable()
export class SocioDatPerSapwebService {

    private resourceUrl =  SERVER_API_URL + 'api/socio-dat-pers';

    constructor(private http: HttpClient) { }

    create(socioDatPer: SocioDatPerSapweb): Observable<EntityResponseType> {
        const copy = this.convert(socioDatPer);
        return this.http.post<SocioDatPerSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(socioDatPer: SocioDatPerSapweb): Observable<EntityResponseType> {
        const copy = this.convert(socioDatPer);
        return this.http.put<SocioDatPerSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SocioDatPerSapweb>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SocioDatPerSapweb[]>> {
        const options = createRequestOption(req);
        return this.http.get<SocioDatPerSapweb[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SocioDatPerSapweb[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SocioDatPerSapweb = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SocioDatPerSapweb[]>): HttpResponse<SocioDatPerSapweb[]> {
        const jsonResponse: SocioDatPerSapweb[] = res.body;
        const body: SocioDatPerSapweb[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SocioDatPerSapweb.
     */
    private convertItemFromServer(socioDatPer: SocioDatPerSapweb): SocioDatPerSapweb {
        const copy: SocioDatPerSapweb = Object.assign({}, socioDatPer);
        return copy;
    }

    /**
     * Convert a SocioDatPerSapweb to a JSON which can be sent to the server.
     */
    private convert(socioDatPer: SocioDatPerSapweb): SocioDatPerSapweb {
        const copy: SocioDatPerSapweb = Object.assign({}, socioDatPer);
        return copy;
    }
}
