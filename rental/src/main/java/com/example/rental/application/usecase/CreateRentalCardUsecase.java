package com.example.rental.application.usecase;


import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserInputDTO;

public interface CreateRentalCardUsecase {
    public RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO);
}
