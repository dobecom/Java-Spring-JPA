package com.example.book.application.usecase;


import com.example.book.framework.web.dto.BookOutPutDTO;

public interface MakeAvailableUsecase {
    public BookOutPutDTO available(Long bookNo);
}
