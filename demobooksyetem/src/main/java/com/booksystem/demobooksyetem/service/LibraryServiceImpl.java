package com.booksystem.demobooksyetem.service;

import com.booksystem.demobooksyetem.controller.model.Book;
import com.booksystem.demobooksyetem.dao.BookDaoModel;
import com.booksystem.demobooksyetem.dao.service.LibraryServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired()
    private LibraryServiceDao libraryServiceDao;

    @Override
    public List<Book> getBooks() {
       // List <Book> books = new ArrayList<>();
        List<BookDaoModel> bookDaloModelList = libraryServiceDao.getBooks();
        List<Book> bookResposeList =  bookDaloModelList.stream().map(x->{
            Book b = new Book();
            b.setAuthorName(x.getAuthorName());
            b.setPublisherName(x.getPublisherName());
            b.setPrice(x.getPrice());
            b.setBookName(x.getBookName());
            b.setId(x.getId());
            return b;
        }).collect(Collectors.toList());
        return bookResposeList;
       // return books;
    }

    @Override
    public Book getBookById(Integer bookId) {
        BookDaoModel bookDaoModel = libraryServiceDao.getBookById(bookId);
        Book book = new Book(bookDaoModel.getBookName(), bookDaoModel.getAuthorName(),bookDaoModel.getPublisherName(),bookDaoModel.getPrice());
        book.setId(bookDaoModel.getId());
        return book;
    }

    @Override
    public Book addBook(Book book) {
        BookDaoModel bookDaoModel =  libraryServiceDao.addBook(book);
        book.setId(bookDaoModel.getId());
        book.setBookName(bookDaoModel.getBookName());
        book.setAuthorName(bookDaoModel.getAuthorName());
        book.setPublisherName(bookDaoModel.getPublisherName());
        book.setPrice(bookDaoModel.getPrice());
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        BookDaoModel bookDaoModel =  libraryServiceDao.updateBook(book);
        book.setId(bookDaoModel.getId());
        book.setBookName(bookDaoModel.getBookName());
        book.setAuthorName(bookDaoModel.getAuthorName());
        book.setPublisherName(bookDaoModel.getPublisherName());
        book.setPrice(bookDaoModel.getPrice());
        return book;
    }

    @Override
    public boolean deleteBook(Integer bookId) {
        return libraryServiceDao.deleteBook(bookId);
    }
}
