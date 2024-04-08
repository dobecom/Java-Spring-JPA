package com.example.book.application.inputport;

import com.example.book.application.outputport.BookOutPutPort;
import com.example.book.application.usecase.MakeAvailableUsecase;
import com.example.book.framework.web.dto.BookOutPutDTO;
import com.example.book.model.Book;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class MakeAvailableInputPort implements MakeAvailableUsecase {

    private final BookOutPutPort bookOutPutPort;
    @Override
    public BookOutPutDTO available(Long bookNo) {
        Book loadBook = bookOutPutPort.loadBook(bookNo);
        loadBook.makeAvailable();
        return BookOutPutDTO.mapToDTO(loadBook);
    }
}
