import { Component, OnInit } from '@angular/core';
import {Book, BookResolved} from '../book';
import {ActivatedRoute} from "@angular/router";
@Component({

  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {
  pageTitle = 'Book Detail';
  book: Book;
  errorMessage: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    const resolvedData: BookResolved =
      this.route.snapshot.data['resolvedData'];
    this.errorMessage = resolvedData.error;
    this.onBookRetrieved(resolvedData.book);
  }

  onBookRetrieved(book: Book): void {
    this.book = book;

    if (this.book) {
      this.pageTitle = `Book Detail: ${this.book.bookName}`;
    } else {
      this.pageTitle = 'No Book found';
    }
  }
}
