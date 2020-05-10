package com.booksystem.demobooksyetem.controller;

import com.booksystem.demobooksyetem.controller.model.Book;
import com.booksystem.demobooksyetem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins="http://localhost:4200")
@RestController

public class LibraryController {
    //@Resource(name="LibraryService")
    @Autowired
    private LibraryService libraryService;

    @RequestMapping( value = "/books" , method =RequestMethod.GET)
    public List<Book> getAllBook() {
        System.out.println("Get all Book");
        List<Book> books = new ArrayList<>();
        books = libraryService.getBooks();
        //bookRepository.findAll().forEach(bookEntries::add);
        return books;
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable Integer bookId) {
        System.out.println("Get all BookID");
        Book book = libraryService.getBookById(bookId);
//
//       // bookRepository.findAll().forEach(bookEntries::add);
//        Book book = new Book();
//        book.setId(1);
//        book.setAuthorName("Amit");
//        book.setBookName("C Programming");
//        book.setPrice(2000);
//        book.setPublisherName("TATA Mc Hill");
        return book;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/books/add")
    public Book addBookDetails(@RequestBody Book book) {
        //JSONPObject  object= new JSONPObject()
        System.out.println("asdasdas");
        Book book1 = new Book();
        book1.setPrice(book.getPrice());
        book1.setAuthorName(book.getAuthorName());
        book1.setBookName(book.getBookName());
        book1.setPublisherName(book.getPublisherName());
        //System.out.println(book1 + " " +book);
        libraryService.addBook(book1);
        return book1;
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
    public Book updateBookDetails(@RequestBody Book book, @PathVariable String bookId) {
        System.out.println("Get all updated book...");
        Book book1 = new Book();
        book1 = libraryService.updateBook(book);
        return book1;
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
    public Boolean deleteBook(@PathVariable Integer bookId) {
        System.out.println("Delete book...");
        boolean success = libraryService.deleteBook(bookId);
        return success;
}
}
