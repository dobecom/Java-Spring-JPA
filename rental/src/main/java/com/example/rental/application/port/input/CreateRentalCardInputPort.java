package com.example.rental.application.port.input;

import com.example.rental.application.port.output.RentalCardOutputPort;
import com.example.rental.application.usecase.CreateRentalCardUsecase;
import com.example.rental.domain.RentalCard;
import com.example.rental.domain.vo.IDName;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserInputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO createRentalCard(UserInputDTO owner) {
        RentalCard rentalCard = RentalCard.createRentalCard(new IDName(owner.getUserId(), owner.getUserNm()));
        RentalCard save = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(save);

    }
}
