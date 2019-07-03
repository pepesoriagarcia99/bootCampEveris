import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  constructor(private http: HttpClient) { }
  getOwners(){
    return this.http.get('https://jsonplaceholder.typicode.com/photos');
  }
}
