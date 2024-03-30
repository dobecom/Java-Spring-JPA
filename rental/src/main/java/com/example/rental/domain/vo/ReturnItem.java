package com.example.rental.domain.vo;

import com.example.rental.domain.RentalItem;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReturnItem {
    @Embedded
    private RentalItem rentalItem;
    private LocalDate returnDate;

    public static ReturnItem createReturnItem(RentalItem rentalItem){
        return new ReturnItem(rentalItem,LocalDate.now());
    }

    public static ReturnItem sample(){
        return ReturnItem.createReturnItem(RentalItem.sample());
    }
}
