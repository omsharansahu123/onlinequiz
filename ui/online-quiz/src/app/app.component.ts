import { Component, OnInit } from '@angular/core';
import { DataService } from './service/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

user:any;

constructor(private dataService: DataService) {}

  ngOnInit(): void {

    this.dataService.currentData.subscribe((data) => (this.user = data));
    
    
  }
  title = 'Online Quiz Application';


}
