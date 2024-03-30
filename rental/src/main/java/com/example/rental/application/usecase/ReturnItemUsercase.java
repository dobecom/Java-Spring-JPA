package com.example.rental.application.usecase;


import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;

public interface ReturnItemUsercase {
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDto) throws Exception;
}
