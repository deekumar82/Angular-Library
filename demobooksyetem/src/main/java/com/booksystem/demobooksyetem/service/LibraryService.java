package com.booksystem.demobooksyetem.service;

import com.booksystem.demobooksyetem.controller.model.Book;
import com.booksystem.demobooksyetem.dao.BookDaoModel;

import java.util.List;

public interface LibraryService {

    public List<Book> getBooks();

    public Book getBookById(Integer bookId);

    public Book addBook(Book book);

    public Book updateBook(Book book);

    public boolean deleteBook(Integer bookId);


}
