package com.booksystem.demobooksyetem.repo;

import com.booksystem.demobooksyetem.dao.BookDaoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface BookRepository extends CrudRepository<BookDaoModel, Integer> {
      //List<Book> aa= new ArrayList<>();

    }

