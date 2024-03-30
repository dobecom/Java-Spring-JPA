package com.example.rental.application.port.input;


import com.example.rental.application.port.output.EventOutputPort;
import com.example.rental.application.port.output.RentalCardOutputPort;
import com.example.rental.application.usecase.ClearOverdueItemUsecase;
import com.example.rental.domain.RentalCard;
import com.example.rental.framework.web.dto.ClearOverdueInfoDTO;
import com.example.rental.framework.web.dto.RentalResultOutputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(clearOverdueInfoDTO.UserId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        rentalCard.makeAvailableRental(clearOverdueInfoDTO.getPoint());

        eventOutputPort.occurOverdueClearedEvent(RentalCard.createOverdueCleardEvent(rentalCard.getMember(),clearOverdueInfoDTO.getPoint()));

        return RentalResultOutputDTO.mapToDTO(rentalCard);
    }
}
