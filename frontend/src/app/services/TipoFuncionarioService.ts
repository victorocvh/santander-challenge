import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import TipoFuncionario from "../model/TipoFuncionario";

@Injectable()
class TipoFuncionarioService {


    constructor(private http: HttpClient) {}    
    urlBase = "http://localhost:8080/api/v1/tipofuncionarios"

    getTipoFuncionario(): Observable<TipoFuncionario[]> {
        return this.http.get<TipoFuncionario[]>(this.urlBase)
    }

    putTipoFuncionario(f: TipoFuncionario) : Observable<any> {
        const url = `${this.urlBase}`
        return this.http.put<any>(url, f)
    }

    postTipoFuncionario(f: TipoFuncionario) : Observable<any> {
        const url = `${this.urlBase}`
        return this.http.post<any>(url,f)
    }

}

export default TipoFuncionarioService;