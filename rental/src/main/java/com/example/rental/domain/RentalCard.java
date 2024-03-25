package com.example.rental.domain;

import com.example.rental.domain.vo.IDName;
import com.example.rental.domain.vo.LateFee;
import com.example.rental.domain.vo.RentStatus;
import com.example.rental.domain.vo.RentalCardNo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RentalCard {
    @EmbeddedId
    private RentalCardNo rentalCardNo;

    @Embedded
    private IDName member;
    private RentStatus rentStatus;
    @Embedded
    private LateFee lateFee;

    public static RentalCard sample(){
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardNo(RentalCardNo.createRentalCardNo());
        rentalCard.setMember(IDName.sampe());
        rentalCard.setRentStatus(RentStatus.RENT_AVAILABLE);
        rentalCard.setLateFee(LateFee.sample());
        return rentalCard;
    }

    public static RentalCard createRentalCard(IDName creator){
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardNo(RentalCardNo.createRentalCardNo());
        rentalCard.setMember(creator);
        rentalCard.setRentStatus(RentStatus.RENT_AVAILABLE);
        rentalCard.setLateFee(LateFee.createLateFee());
        return rentalCard;
    }
}
