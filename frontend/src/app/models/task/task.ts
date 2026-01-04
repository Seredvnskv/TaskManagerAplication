import {TaskStatus} from '../enums/task_status/task-status';

export interface Task {
  id: string;
  title: string;
  description: string;
  status: TaskStatus;
  createdAt: Date;
  updatedAt: Date;
  dueDate: Date;
}
