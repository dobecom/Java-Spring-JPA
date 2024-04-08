package com.example.book.application.usecase;


import com.example.book.framework.web.dto.BookOutPutDTO;

public interface MakeUnAvailableUsecase {
    public BookOutPutDTO unavailable(Long bookNo);
}
