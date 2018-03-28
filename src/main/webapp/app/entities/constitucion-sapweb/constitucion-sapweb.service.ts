import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { ConstitucionSapweb } from './constitucion-sapweb.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<ConstitucionSapweb>;

@Injectable()
export class ConstitucionSapwebService {

    private resourceUrl =  SERVER_API_URL + 'api/constitucions';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) { }

    create(constitucion: ConstitucionSapweb): Observable<EntityResponseType> {
        const copy = this.convert(constitucion);
        return this.http.post<ConstitucionSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(constitucion: ConstitucionSapweb): Observable<EntityResponseType> {
        const copy = this.convert(constitucion);
        return this.http.put<ConstitucionSapweb>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ConstitucionSapweb>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<ConstitucionSapweb[]>> {
        const options = createRequestOption(req);
        return this.http.get<ConstitucionSapweb[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<ConstitucionSapweb[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: ConstitucionSapweb = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<ConstitucionSapweb[]>): HttpResponse<ConstitucionSapweb[]> {
        const jsonResponse: ConstitucionSapweb[] = res.body;
        const body: ConstitucionSapweb[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to ConstitucionSapweb.
     */
    private convertItemFromServer(constitucion: ConstitucionSapweb): ConstitucionSapweb {
        const copy: ConstitucionSapweb = Object.assign({}, constitucion);
        copy.fecact = this.dateUtils
            .convertLocalDateFromServer(constitucion.fecact);
        copy.fecactnom = this.dateUtils
            .convertLocalDateFromServer(constitucion.fecactnom);
        return copy;
    }

    /**
     * Convert a ConstitucionSapweb to a JSON which can be sent to the server.
     */
    private convert(constitucion: ConstitucionSapweb): ConstitucionSapweb {
        const copy: ConstitucionSapweb = Object.assign({}, constitucion);
        copy.fecact = this.dateUtils
            .convertLocalDateToServer(constitucion.fecact);
        copy.fecactnom = this.dateUtils
            .convertLocalDateToServer(constitucion.fecactnom);
        return copy;
    }
}
