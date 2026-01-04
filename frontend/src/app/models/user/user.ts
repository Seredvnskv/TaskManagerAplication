import {Role} from '../enums/role/role';

export interface User {
  id: string;
  username: string;
  email: string;
  createdAt: Date;
  role: Role;
}
