import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import Produto from "../model/Produto";


@Injectable()
class ProdutoService {

    constructor(private http: HttpClient) {}    
    urlBase = "http://localhost:8080/api/v1/produtos"

    getProdutos(): Observable<Produto[]> {
        return this.http.get<Produto[]>(this.urlBase)
    }

    putProduto(produto: Produto, funcionarioId: Number) : Observable<any> {
        const url = `${this.urlBase}?funcionarioId=${funcionarioId}`
        return this.http.put<any>(url, produto)
    }

    postProduto(produto: Produto, funcionarioId: Number) : Observable<any> {
        const url = `${this.urlBase}?funcionarioId=${funcionarioId}`
        return this.http.post<any>(url,produto)
    }

}

export default ProdutoService;