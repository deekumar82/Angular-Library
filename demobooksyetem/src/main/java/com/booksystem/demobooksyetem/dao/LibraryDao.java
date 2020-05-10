package com.booksystem.demobooksyetem.dao;

import com.booksystem.demobooksyetem.controller.model.Book;
import com.booksystem.demobooksyetem.repo.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibraryDao {
    private final BookRepository bookRepository;

    public LibraryDao(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDaoModel> getBooks() {
        System.out.println("Get all Customers...");
        return (List<BookDaoModel>) bookRepository.findAll();
    }
    public BookDaoModel getBookById(Integer bookId) {
        //bookRepository.findById(bookId);
        Optional <BookDaoModel> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            return book.get();
        }
        return new BookDaoModel();
    }

    public BookDaoModel addBook(Book book) {
        BookDaoModel bookDaoModel = new BookDaoModel(
                                            book.getBookName(),
                                            book.getAuthorName(),
                                            book.getPublisherName(),
                                            book.getPrice());
        bookDaoModel = bookRepository.save(bookDaoModel);
        return bookDaoModel;
    }

    public BookDaoModel updateBook(Book book) {
        BookDaoModel bookDaoModel = new BookDaoModel(
                book.getBookName(),
                book.getAuthorName(),
                book.getPublisherName(),
                book.getPrice());
        bookDaoModel.setId(book.getId());
        bookDaoModel = bookRepository.save(bookDaoModel);
        return bookDaoModel;
    }

    public boolean deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
        Optional<BookDaoModel> bookDaoModel =  bookRepository.findById(bookId);
        if(bookDaoModel.isPresent()) {
             return false;
        }

        return true;
    }
}
