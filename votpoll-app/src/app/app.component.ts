import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PollComponent } from "./poll/poll.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PollComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'votpoll-app';
}
