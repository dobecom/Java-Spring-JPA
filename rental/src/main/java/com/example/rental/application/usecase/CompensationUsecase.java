package com.example.rental.application.usecase;


import com.example.rental.domain.RentalCard;
import com.example.rental.domain.vo.IDName;
import com.example.rental.domain.vo.Item;

public interface CompensationUsecase {

    public RentalCard cancleRentItem(IDName idName, Item item);
    public RentalCard cancleReturnItem(IDName idName,Item item, long point) throws Exception;
    public long cancleMakeAvailableRental(IDName idName, long point);


}
