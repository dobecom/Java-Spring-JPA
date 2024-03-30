package com.example.rental.application.usecase;


import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;

public interface OverdueItemUsercase {
    public RentalCardOutputDTO overDueItem(UserItemInputDTO rental) throws Exception;
}
