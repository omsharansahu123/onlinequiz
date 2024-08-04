import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  
  private apiUrl = 'http://localhost:8080/'; // Update with your actual backend URL


  constructor(private http: HttpClient  ) { 
 
  }

  login(value: any) {
    return this.http.post(`${this.apiUrl}User/login`,value)
  }

  getQuizes() {
    return this.http.get(`${this.apiUrl}Quiz/search`);
  }

  getQuestions(quizId:any) {
    return this.http.get(`${this.apiUrl}Question/findByQuizId/${quizId}`);
  }

  getOptions() {
    return this.http.get(`${this.apiUrl}Option/search`);
  }
  updateAtteptQuiz(id: number) {
    console.log("attemp id : "+id);

    let data = {
      quiz:{
        id:id,
      },
      user:{
        id:1  
      }
    }
    
    return this.http.post(`${this.apiUrl}QuizAttempt/update`,data);
  }

  updateUserAns(userAns: any) {
    return this.http.post(`${this.apiUrl}UserAnswer/update`,userAns)
  }

  updateResult(quizAttempt: any) {
    let data = {
      quizAttempt:quizAttempt
    }
    return this.http.post(`${this.apiUrl}QuizAttempt/updateResult`,data);
  }

  getScoreByQuizAttemptId(attemptQuizId: any) {
    return this.http.get(`${this.apiUrl}QuizAttempt/findById/${attemptQuizId}`);
  }
}
