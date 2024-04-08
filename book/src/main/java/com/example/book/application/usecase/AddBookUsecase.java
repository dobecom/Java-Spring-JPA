package com.example.book.application.usecase;


import com.example.book.framework.web.dto.BookInfoDTO;
import com.example.book.framework.web.dto.BookOutPutDTO;

public interface AddBookUsecase {
    public BookOutPutDTO addBook(BookInfoDTO bookInfoDTO);
}
