import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import Cliente from "../model/Cliente";

@Injectable()
class ClienteService {

    constructor(private http: HttpClient) {}    
    urlBase = "http://localhost:8080/api/v1/clientes"

    getClientes(): Observable<Cliente[]> {
        return this.http.get<Cliente[]>(this.urlBase)
    }

    putCliente(f: Cliente) : Observable<Cliente> {
        const url = `${this.urlBase}`
        return this.http.put<Cliente>(url, f)
    }

    postCliente(f: Cliente) : Observable<Cliente> {
        const url = `${this.urlBase}`
        return this.http.post<Cliente>(url,f)
    }

}

export default ClienteService;