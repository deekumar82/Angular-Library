import { Component, OnInit } from '@angular/core';
import {Book, BookResolved} from '../book';
import {BookService} from "../book.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({

  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit {
  pageTitle = 'Book Edit';
  errorMessage: string;

  private dataIsValid: { [key: string]: boolean } = {};

  get isDirty(): boolean {
    return JSON.stringify(this.originalBook) !== JSON.stringify(this.currentBook);
  }

  private currentBook: Book;
  private originalBook: Book;

  get book(): Book {
    return this.currentBook;
  }
  set book(value: Book) {
    this.currentBook = value;
    // Clone the object to retain a copy
    this.originalBook = value ? { ...value } : null;
  }

  constructor(private booksService: BookService,
              //private messageService: MessageService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.route.data.subscribe(data => {
      const resolvedData: BookResolved = data['resolvedData'];
      this.errorMessage = resolvedData.error;
      this.onBookRetrieved(resolvedData.book);
    });
  }

  onBookRetrieved(book: Book): void {
    this.book = book;

    if (!this.book) {
      this.pageTitle = 'No Book found';
    } else {
      if (this.book.id === 0) {
        this.pageTitle = 'Add Book';
      } else {
        this.pageTitle = `Edit Book: ${this.book.bookName}`;
      }
    }
  }

  deleteBook(): void {
    if (this.book.id === 0) {
      // Don't delete, it was never saved.
      this.onSaveComplete(`${this.book.bookName} was deleted`);
    } else {
      if (confirm(`Really delete the product: ${this.book.bookName}?`)) {
        this.booksService.deleteBook(this.book.id).subscribe({
          next: () => this.onSaveComplete(`${this.book.bookName} was deleted`),
          error: err => this.errorMessage = err
        });
      }
    }
  }

  isValid(path?: string): boolean {
    this.validate();
    if (path) {
      return this.dataIsValid[path];
    }
    return (this.dataIsValid &&
      Object.keys(this.dataIsValid).every(d => this.dataIsValid[d] === true));
  }

  reset(): void {
    this.dataIsValid = null;
    this.currentBook = null;
    this.originalBook = null;
  }

  saveBook(): void {
    if (this.isValid()) {
      if (this.book.id === 0) {
        this.booksService.createBook(this.book).subscribe({
          next: () => this.onSaveComplete(`The new ${this.book.bookName} was saved`),
          error: err => this.errorMessage = err
        });
      } else {
        this.booksService.updateBook(this.book).subscribe({
          next: () => this.onSaveComplete(`The updated ${this.book.bookName} was saved`),
          error: err => this.errorMessage = err
        });
      }
    } else {
      this.errorMessage = 'Please correct the validation errors.';
    }
  }

  onSaveComplete(message?:string): void {
    this.reset();

    // Navigate back to the Book list
    this.router.navigate(['/books']);
  }

  validate(): void {

    this.dataIsValid = {};

    if (this.book.bookName &&
      this.book.bookName.length >= 3) {
      this.dataIsValid['info'] = true;
    } else {
      this.dataIsValid['info'] = false;
    }

  }
}
