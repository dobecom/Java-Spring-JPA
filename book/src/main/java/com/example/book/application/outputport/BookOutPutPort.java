package com.example.book.application.outputport;

import com.example.book.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOutPutPort {
    public Book loadBook(long bookNo);

    public Book save(Book book);
}
