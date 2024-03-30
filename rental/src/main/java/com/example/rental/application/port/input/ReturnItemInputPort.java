package com.example.rental.application.port.input;

import com.example.rental.application.port.output.EventOutputPort;
import com.example.rental.application.port.output.RentalCardOutputPort;
import com.example.rental.application.usecase.ReturnItemUsercase;
import com.example.rental.domain.RentalCard;
import com.example.rental.domain.event.ItemReturned;
import com.example.rental.domain.vo.Item;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnItemInputPort implements ReturnItemUsercase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;
    @Override
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDto) throws Exception {
        // OutputPort를 사용해서 rentalCard 검색한 후 없으면 Exception처리, 있으면 도서 반납
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(returnDto.userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        Item retrunItem = new Item(returnDto.getItemId(),returnDto.getItemTitle());
        rentalCard.returnItem(retrunItem, LocalDate.now());
        //이벤트 생성 발행
        ItemReturned itemReturnEvent = RentalCard.createItemReturnEvent(rentalCard.getMember(), retrunItem, 10L);
        eventOutputPort.occurReturnEvent(itemReturnEvent);

        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
