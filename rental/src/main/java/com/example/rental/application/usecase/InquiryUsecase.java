package com.example.rental.application.usecase;


import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserInputDTO;

import java.util.Optional;

public interface InquiryUsecase {
    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO);
}
