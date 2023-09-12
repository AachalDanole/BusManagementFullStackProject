import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Bus } from './bus';

@Injectable({
  providedIn: 'root'
})  
export class BusService {

  private baseURL = "http://localhost:8080/api/v1/bus";

  constructor(private httpClient: HttpClient) { }
  
  getBusList(): Observable<Bus[]>{
    return this.httpClient.get<Bus[]>(`${this.baseURL}/allBus`);
  }

  saveBusDetails(bus: Bus): Observable<Object>{
    return this.httpClient.post<Bus>(`${this.baseURL}/saveBus`,bus);
  }

  getBusDetailsById(busId: number): Observable<Bus>{
    return this.httpClient.get<Bus>(`${this.baseURL}/readBus/${busId}`);
  }

  updateBus(busId: number, bus: Bus): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateBus/${busId}`, bus);
  }

 
  deleteBusDetailsById(busId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteBus/${busId}`);
  }

  toDeleteAllBusDetails(): Observable<any>{
    console.log("i an alldelete");
    return this.httpClient.delete(`${this.baseURL}/deleteAllBuses`);
  }

  findByAcDomain(): Observable<Bus[]> {
    console.log("i came here");
    return this.httpClient.get<Bus[]>(`${this.baseURL}/ACBus`);
  }

  findByNonAcDomain(): Observable<Bus[]> {
   console.log("non ac");
    return this.httpClient.get<Bus[]>(`${this.baseURL}/nonACBus`);
  }
  

  findBytravelsName(travelsName:any):Observable<Bus[]>{
      return this.httpClient.get<Bus[]>(`${this.baseURL}/allBus?name=${travelsName}`);
    }

    getBusDetailsBySrcDest(src : any, dest:any) :Observable<Bus[]>{
      console.log('i am here');
      console.log(src,dest); return this.httpClient.get<Bus[]>(`${this.baseURL}/matchRoutes?src=${src}&dest=${dest}`);
    }

    sortByCost(pathVar:string,fieldName:String):Observable<Bus[]>{
      console.log('i am here');
      return this.httpClient.get<Bus[]>(`${this.baseURL}/filter/Price/${pathVar}?price=${fieldName}`);
    }
    
    
    sortByRatings(pathVar:String,fieldName:String):Observable<Bus[]>{
      console.log(pathVar,fieldName);
      console.log('i am here');
        return this.httpClient.get<Bus[]>(`${this.baseURL}/filter/Rating/${pathVar}?rating=${fieldName}`);
       }

}


