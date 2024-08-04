import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuizService } from 'src/app/service/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  quizId: any;
  currentQuestionIndex = 0;
  index = 0;
  // questions = [
  //   { text: 'What is the capital of France?', options: ['Paris', 'London', 'Rome','japan'], correctAnswers: [0] }
  // ];
  questions:any;
  selectedOption=[{"isCorrect":true}];
  attemptQuiz :any;
  userAns: any;

  constructor(private route: ActivatedRoute, 
    private router: Router,
    private service : QuizService) {}

  ngOnInit() {
    // this.quizId = +this.route.snapshot.paramMap.get('id');
    this.route.paramMap.subscribe(params => {
      this.quizId = params.get('id');
      console.log('quizId:', this.quizId);
      // Perform actions based on updated searchTerm
    });
    
    this.service.updateAtteptQuiz(this.quizId).subscribe((results) => {
     
      console.log(results);
      this.attemptQuiz=results;
      
    },
  (error)=>{
    console.log(error);
    
  });

    
   

    this.service.getQuestions(this.quizId).subscribe((results) => {
      this.questions = results;
      console.log(this.questions);
      
    },
  (error)=>{
    console.log(error);
    
  });

    // Fetch quiz questions based on quizId here
  }

  submitAnswer(value:any) {
    // Check if answer is correct and provide feedback
    
    
      let userAns= {
        quizAttempt:{id:this.attemptQuiz?.id},
        question:{id:this.questions[this.currentQuestionIndex]?.id},
        selectedOption:this.selectedOption[this.index],
        isCorrect:this.selectedOption[this.index].isCorrect
      }

      console.log("testttt");
      console.log(this.selectedOption);
      
      

      this.service.updateUserAns(userAns).subscribe((results) => {
     
        console.log(results);
        this.userAns=results;
        
      },
    (error)=>{
      console.log(error);
      
    });
    
    if(value==1){
      this.service.updateResult(this.attemptQuiz).subscribe((results) => {
     
        console.log(results);
        this.attemptQuiz=results;
        
      },
    (error)=>{
      console.log(error);
      
    });

    }

    this.currentQuestionIndex++;
    if(this.currentQuestionIndex<this.questions.length){
      this.index=this.currentQuestionIndex;
    }
    if (this.currentQuestionIndex >= this.questions.length) {
      this.router.navigate(['/results', this.attemptQuiz?.id]);
    }
    
  }

  previousQuestion() {
    this.currentQuestionIndex--;
    this.index--;
  }
}
