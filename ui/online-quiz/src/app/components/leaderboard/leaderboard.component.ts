import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {
  topScorers = [
    { username: 'Alice', score: 95 },
    { username: 'Bob', score: 90 },
    { username: 'Charlie', score: 85 }
  ];

  ngOnInit() {
    // Fetch leaderboard data here
  }
}
