/* Defines the Book entity */
export interface Book {
  id: number;
  bookName: string;
  authorName: string;
  publisherName: string;
  price: number;
}

export interface BookResolved {
  book: Book;
  error?: any;
}
