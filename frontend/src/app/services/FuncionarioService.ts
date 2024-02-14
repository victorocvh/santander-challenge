import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import Funcionario from "../model/Funcionario";

@Injectable()
class FuncionarioService {

    constructor(private http: HttpClient) {}    
    urlBase = "http://localhost:8080/api/v1/funcionarios"

    getFuncionarios(): Observable<Funcionario[]> {
        return this.http.get<Funcionario[]>(this.urlBase)
    }

    putFuncionario(f: Funcionario) : Observable<any> {
        const url = `${this.urlBase}`
        return this.http.put<any>(url, f)
    }

    postFuncionario(f: Funcionario) : Observable<any> {
        const url = `${this.urlBase}`
        return this.http.post<any>(url,f)
    }

}

export default FuncionarioService;