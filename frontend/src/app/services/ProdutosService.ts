import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";


@Injectable()
class ProdutoService {


    constructor(private http: HttpClient) {}    
    
    getProdutos() {
        return this.http.get('http://localhost:8080/api/v1/produtos')
    }

}

export default ProdutoService;