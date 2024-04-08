package com.example.book.application.inputport;

import com.example.book.application.outputport.BookOutPutPort;
import com.example.book.application.usecase.InquiryUsecase;
import com.example.book.framework.web.dto.BookOutPutDTO;
import com.example.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class InquiryInputPort implements InquiryUsecase {

    private final BookOutPutPort bookOutPort;
    @Override
    public BookOutPutDTO getBookInfo(long bookNo) {
        Book loadBook = bookOutPort.loadBook(bookNo);
        return BookOutPutDTO.mapToDTO(loadBook);
    }
}
