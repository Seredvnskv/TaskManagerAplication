import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Header} from './ui/component/header/header';
import {Main} from './ui/component/main/main';
import {Footer} from './ui/component/footer/footer';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, Main, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
