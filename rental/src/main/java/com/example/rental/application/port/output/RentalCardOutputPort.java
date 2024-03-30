package com.example.rental.application.port.output;

import com.example.rental.domain.RentalCard;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalCardOutputPort {
    Optional<RentalCard> loadRentalCard(String userId);
    RentalCard save(RentalCard rentalCard);
}
