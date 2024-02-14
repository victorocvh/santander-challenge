import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import Venda from "../model/Venda";
import { Observable } from "rxjs";

@Injectable()
class VendasService {

    constructor(private http: HttpClient) { }
    urlBase = "http://localhost:8080/api/v1/vendas"
    
    AddVenda(venda : Venda) : Observable<Venda> {
        return this.http.post<Venda>(this.urlBase, venda)
    }

    getVendas() : Observable<Venda[]> {
        return this.http.get<Venda[]>(this.urlBase);
    }

}

export default VendasService;