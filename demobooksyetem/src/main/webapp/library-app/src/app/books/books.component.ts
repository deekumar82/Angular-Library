import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from './book';
import { BookService } from './book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})

export class BooksComponent implements OnInit {

  pageTitle = 'Book List';
  errorMessage = '';
  books: Book[] = [];

  constructor(private bookService: BookService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.bookService.getBooks().subscribe({
      next: books => {
        this.books = books;
      },
      error: err => this.errorMessage = err
    });
  }


}
