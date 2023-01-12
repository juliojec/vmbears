import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(private httpClient: HttpClient) { }

  save(file: any): Observable<any> {
    const data: FormData = new FormData();
    data.append('file', file);
    return this.httpClient.post(environment.server + '/agente/upload', data, { responseType: 'text' });
  }

  findBySigla(sigla: String): Observable<any> {
    return this.httpClient.get(environment.server + '/agente/sigla/' + sigla);
  }

}
