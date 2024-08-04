import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { error } from 'console';
import { QuizService } from 'src/app/service/quiz.service';

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.css']
})
export class QuizListComponent implements OnInit {
  // quizzes = [
  //   { id: 1, title: 'General Knowledge', topic: 'Trivia' },
  //   { id: 2, title: 'Science', topic: 'Physics' }
  // ];
  quizzes:any;

  constructor(private router: Router,
    private service:QuizService
  ) {


  }

ngOnInit(): void {
  console.log("inside on init");
  
    this.service.getQuizes().subscribe((results) => {
      this.quizzes = results;
      console.log(this.quizzes);
      
    },
  (error)=>{
    console.log(error);
    
  });
  }

  startQuiz(id: number) {
    this.router.navigate(['/quiz', id]);
  }
}
