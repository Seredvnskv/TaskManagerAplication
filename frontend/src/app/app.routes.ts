import {RouterModule, Routes} from '@angular/router';
import {TaskListView} from './components/task_components/task-list-view/task-list-view';
import {NgModule} from '@angular/core';
import {UserListView} from './components/user_components/user-list-view/user-list-view';

export const routes: Routes = [
  {
    path: "tasks",
    component: TaskListView
  },
  {
    path: "users",
    component: UserListView
  },
  {
    path: "users/username/:username",
    component: UserListView
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}

