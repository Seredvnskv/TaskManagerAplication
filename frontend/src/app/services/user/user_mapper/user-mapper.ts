import {ReadUserDTO} from '../../../models/user/dto/read-user-dto';
import {User} from '../../../models/user/user';
import {Role} from '../../../models/enums/role/role';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserMapper {
  toEntity(dto: ReadUserDTO): User {
    return {
      id: dto.id,
      username: dto.username,
      email: dto.email,
      createdAt: new Date(dto.createdAt),
      role: Role[dto.role as keyof typeof Role],
    };
  }

  toDto(entity: User): ReadUserDTO {
    return {
      id: entity.id,
      username: entity.username,
      email: entity.email,
      createdAt: entity.createdAt,
      role: Role[entity.role],
    };
  }
}
