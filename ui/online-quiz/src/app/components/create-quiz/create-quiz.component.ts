import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.css']
})
export class CreateQuizComponent {
  quizForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) {
    this.quizForm = this.fb.group({
      title: ['', Validators.required],
      description: [''],
      questions: this.fb.array([])
    });
    this.addQuestion(); // Initialize with one question for demonstration
  }

  get questions() {
    return this.quizForm.get('questions') as FormArray;
  }

  addQuestion() {
    this.questions.push(this.fb.group({
      questionText: ['', Validators.required],
      options: this.fb.array([]),
      correctAnswers: this.fb.array([]) // Assuming correctAnswers is required
    }));
    this.addOption(this.questions.length - 1); // Add one option initially
  }

  addOption(questionIndex: number) {
    (this.questions.at(questionIndex).get('options') as FormArray).push(this.fb.control(''));
  }

  getOptions(questionIndex: number) {
    return this.questions.at(questionIndex).get('options') as FormArray;
  }

  onSubmit() {
    if (this.quizForm.valid) {
      // Implement quiz creation logic here
      this.router.navigate(['/dashboard']);
    }
  }
}
