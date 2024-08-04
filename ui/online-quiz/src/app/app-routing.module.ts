import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './components/signup/signup.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CreateQuizComponent } from './components/create-quiz/create-quiz.component';
import { QuizListComponent } from './components/quiz-list/quiz-list.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { ResultsComponent } from './components/results/results.component';
import { ProfileComponent } from './components/profile/profile.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { LoginComponent } from './components/login/login.component';

// Define the routes for the application
const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'dashboard', component: DashboardComponent },
    { path: 'create-quiz', component: CreateQuizComponent },
    { path: 'manage-quizzes', component: CreateQuizComponent }, // Assuming same component for manage quizzes
    { path: 'quizzes', component: QuizListComponent },
    { path: 'quiz/:id', component: QuizComponent },
    { path: 'results/:id', component: ResultsComponent },
    { path: 'profile', component: ProfileComponent },
    { path: 'leaderboard', component: LeaderboardComponent },
    { path: '', redirectTo: '/login', pathMatch: 'full' }
  ];

  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }