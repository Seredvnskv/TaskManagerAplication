export interface ReadTaskDTO {
  id: string;
  title: string;
  description: string;
  status: string;
  createdBy: string;
  createdAt: Date;
  updatedAt: Date;
  dueDate: Date;
}
