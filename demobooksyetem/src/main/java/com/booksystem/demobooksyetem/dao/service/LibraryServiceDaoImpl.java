package com.booksystem.demobooksyetem.dao.service;
import com.booksystem.demobooksyetem.controller.model.Book;
import com.booksystem.demobooksyetem.dao.BookDaoModel;
import com.booksystem.demobooksyetem.dao.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibraryServiceDaoImpl  implements  LibraryServiceDao {

    @Autowired
    private LibraryDao libraryDao;

    @Override
    public List<BookDaoModel> getBooks() {
        return libraryDao.getBooks();
    }

    @Override
    public BookDaoModel getBookById(Integer bookId) {
        return libraryDao.getBookById(bookId);
    }

    @Override
    public BookDaoModel addBook(Book book) { return libraryDao.addBook(book); }

    @Override
    public BookDaoModel updateBook(Book book) { return libraryDao.updateBook(book); }

    @Override
    public boolean deleteBook(Integer bookId) {
         return libraryDao.deleteBook(bookId);
    }

}
