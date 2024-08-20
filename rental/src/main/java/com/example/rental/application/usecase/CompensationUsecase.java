package com.example.rental.application.usecase;


import com.example.rental.domain.RentalCard;
import com.example.rental.domain.vo.IDName;
import com.example.rental.domain.vo.Item;

public interface CompensationUsecase {

    public RentalCard cancelRentItem(IDName idName, Item item);
    public RentalCard cancelReturnItem(IDName idName,Item item, long point) throws Exception;
    public long cancelMakeAvailableRental(IDName idName, long point);


}
