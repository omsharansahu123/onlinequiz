import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  quizHistory = [
    { title: 'General Knowledge', score: 80, date: '2024-07-14' },
    { title: 'Science', score: 90, date: '2024-07-13' }
  ];

  ngOnInit() {
    // Fetch user quiz history here
  }
}
