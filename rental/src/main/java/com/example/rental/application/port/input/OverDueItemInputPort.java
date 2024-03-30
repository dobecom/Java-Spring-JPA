package com.example.rental.application.port.input;

import com.example.rental.application.port.output.RentalCardOutputPort;
import com.example.rental.application.usecase.OverdueItemUsercase;
import com.example.rental.domain.RentalCard;
import com.example.rental.domain.vo.Item;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class OverDueItemInputPort implements OverdueItemUsercase {

    private final RentalCardOutputPort rentalCardOutputPort;
    @Override
    public RentalCardOutputDTO overDueItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        rentalCard.overdueItem(new Item(rental.getItemId(),rental.getItemTitle()));
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
