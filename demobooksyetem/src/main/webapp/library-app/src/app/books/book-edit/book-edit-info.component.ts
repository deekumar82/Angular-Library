import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import { Book } from '../book';

@Component({
  templateUrl: './book-edit-info.component.html'
})
export class BookEditInfoComponent implements OnInit {
  @ViewChild(NgForm,{static :false}) bookForm: NgForm;

  errorMessage: string;
  book: Book;

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.parent.data.subscribe(data => {
      if (this.bookForm) {
        this.bookForm.reset();
      }

      this.book = data['resolvedData'].book;
    });
  }

}
