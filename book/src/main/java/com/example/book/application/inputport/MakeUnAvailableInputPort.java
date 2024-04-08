package com.example.book.application.inputport;

import com.example.book.application.outputport.BookOutPutPort;
import com.example.book.application.usecase.MakeUnAvailableUsecase;
import com.example.book.framework.web.dto.BookOutPutDTO;
import com.example.book.model.Book;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class MakeUnAvailableInputPort implements MakeUnAvailableUsecase {
    private final BookOutPutPort bookOutPutPort;
    @Override
    public BookOutPutDTO unavailable(Long bookNo) {
        Book loadBook = bookOutPutPort.loadBook(bookNo);
        loadBook.makeUnAvailable();
        return BookOutPutDTO.mapToDTO(loadBook);
    }
}
