import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../services/user/user_service/user-service';

@Component({
  selector: 'app-user-list-view',
  imports: [],
  templateUrl: './user-list-view.html',
  styleUrl: './user-list-view.css',
})
export class UserListView implements OnInit {
  constructor(private  userService: UserService) {}

  ngOnInit(): void  {
    this.userService.getUsers().subscribe(
      users => {
        console.log(users);
      }
    );
  }
}
