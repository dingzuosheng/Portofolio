import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit{
  loginForm: FormGroup = new FormGroup({});

  ngOnInit(): void {}

  initialLoginForm() {
    this.loginForm = new FormGroup({

    })
  }

  onSubmit() {

  }
}
