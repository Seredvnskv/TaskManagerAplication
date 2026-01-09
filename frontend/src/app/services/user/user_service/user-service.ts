import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserMapper} from '../user_mapper/user-mapper';
import {map, Observable} from 'rxjs';
import {User} from '../../../models/user/user';
import {ReadUserDTO} from '../../../models/user/dto/read-user-dto';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private  http: HttpClient, private userMapper: UserMapper) {}

  getUsers(): Observable<User[]>{
    return this.http.get<ReadUserDTO[]>('api/users')
      .pipe(map(response => this.userMapper.collectionDtoToEntity(response)));
  }

  getUserByUsername(username: string): Observable<User> {
    return this.http.get<ReadUserDTO>(`api/users/username/${username}`)
      .pipe(map(response => this.userMapper.toEntity(response)));
  }

  getUserByEmail(email: string): Observable<User> {
    return this.http.get<ReadUserDTO>(`api/users/email/${email}`)
      .pipe(map(response => this.userMapper.toEntity(response)));
  }

  getUserById(id: string): Observable<User> {
    return this.http.get<ReadUserDTO>(`api/users/${id}`)
      .pipe(map(response => this.userMapper.toEntity(response)));
  }
}
