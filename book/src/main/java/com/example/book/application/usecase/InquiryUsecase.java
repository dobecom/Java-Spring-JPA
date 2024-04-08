package com.example.book.application.usecase;


import com.example.book.framework.web.dto.BookOutPutDTO;

public interface InquiryUsecase {
    public BookOutPutDTO getBookInfo(long bookNo);
}
