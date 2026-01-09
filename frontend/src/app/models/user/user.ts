import {Role} from '../enums/role/role';

export interface User {
  id: string;
  username: string;
  email: string;
  role: Role;
  createdAt: Date;
}
