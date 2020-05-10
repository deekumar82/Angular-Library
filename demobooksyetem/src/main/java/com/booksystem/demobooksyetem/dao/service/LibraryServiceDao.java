package com.booksystem.demobooksyetem.dao.service;

import com.booksystem.demobooksyetem.controller.model.Book;
import com.booksystem.demobooksyetem.dao.BookDaoModel;

import java.util.List;

public interface LibraryServiceDao {

    public List<BookDaoModel> getBooks();

    public BookDaoModel getBookById(Integer bookId);

    public BookDaoModel addBook(Book book);

    public BookDaoModel updateBook(Book book);

    public boolean deleteBook(Integer bookId);


}
