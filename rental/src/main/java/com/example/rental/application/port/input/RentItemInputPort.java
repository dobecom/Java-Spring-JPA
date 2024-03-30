package com.example.rental.application.port.input;

import com.example.rental.application.port.output.EventOutputPort;
import com.example.rental.application.port.output.RentalCardOutputPort;
import com.example.rental.application.usecase.RentItemUsecase;
import com.example.rental.domain.RentalCard;
import com.example.rental.domain.event.ItemRented;
import com.example.rental.domain.vo.IDName;
import com.example.rental.domain.vo.Item;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class RentItemInputPort implements RentItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId)
                .orElseGet(() -> RentalCard.createRentalCard(new IDName(rental.getUserId(), rental.getUserNm())));

        Item newItem = new Item(rental.getItemId(),rental.getItemTitle());
        rentalCard.rentItem(newItem);
        //대여 이벤트 생성 및 발행
        ItemRented itemRentedEvent = RentalCard.createItemRentedEvent(rentalCard.getMember(), newItem, 10L);
        eventOutputPort.occurRentalEvent(itemRentedEvent);

        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
