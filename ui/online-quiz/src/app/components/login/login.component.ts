import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { QuizService } from 'src/app/service/quiz.service';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private service:QuizService, private dataService: DataService) {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
  ngOnInit(): void {
    let data = {isLoggedIn:false}
    this.dataService.changeData(data);
  }

  userData : any;
  isLoggedIn=false;

  onSubmit() {
    if (this.loginForm.valid) {
      // Implement authentication logic here
      console.log(this.loginForm.value);
      
      this.service.login(this.loginForm.value).subscribe((results) => {
        this.isLoggedIn=true;
        this.userData=results;

        this.userData.isLoggedIn = true;
        this.dataService.changeData(this.userData);

        this.router.navigate(['/quizzes']);
      },
    (error)=>{
      console.log(error);
      alert(error.error.message)
      
      
    });

      
    }
  }
}
