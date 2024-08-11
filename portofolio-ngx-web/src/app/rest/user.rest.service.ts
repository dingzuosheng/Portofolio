import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Project, User} from "../core/model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class UserRestService {
  apiUrl = environment.aipEndpoints.portofolioBaseUrl;

  constructor(private http: HttpClient) {}

  public registerUser(user: User): Observable<void> {
    const headers = { 'Content-Type': 'application/json' };
    return this.http.post<void>(`${this.apiUrl}/api/user`, user, {headers});
  }

  public loadUser(id: string): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/api/user/${id}`);
  }

  public saveProject(id: string, project: Project): Observable<void> {
    const headers = { 'Content-Type': 'application/json' };
    return this.http.post<void>(`${this.apiUrl}/api/user/${id}/projects`, project, {headers});
  }

}
