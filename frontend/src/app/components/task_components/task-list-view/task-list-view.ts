import { Component, OnInit } from '@angular/core';
import {TaskService} from '../../../services/task/task_service/task-service';

@Component({
  selector: 'app-task-list-view',
  imports: [],
  templateUrl: './task-list-view.html',
  styleUrl: './task-list-view.css',
})
export class TaskListView implements OnInit {
  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.taskService.getTasks().subscribe(tasks => {
      console.log(tasks);
    });
  }
}
