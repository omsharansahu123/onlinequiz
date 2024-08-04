import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from 'src/app/service/quiz.service';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {
  attemptQuizId: any;
  score: any;
  feedback: any;

  constructor(private route: ActivatedRoute,  private service : QuizService) {}

  ngOnInit() {
    // this.quizId = this.route.snapshot.paramMap.get('id');
    
    // Calculate and display the score and feedback here
    this.score = 80;  // Example score
    this.feedback = 'Well done!';  // Example feedback



    this.route.paramMap.subscribe(params => {
      this.attemptQuizId = params.get('id');
      console.log('attemptQuizId:', this.attemptQuizId);
      // Perform actions based on updated searchTerm
    });
    
    this.service.getScoreByQuizAttemptId(this.attemptQuizId).subscribe((results) => {
     
      console.log(results);
      this.score=results;
      
    },
  (error)=>{
    console.log(error);
    
  });
  }
}
