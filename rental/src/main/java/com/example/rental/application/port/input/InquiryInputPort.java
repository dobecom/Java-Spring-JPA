package com.example.rental.application.port.input;

import com.example.rental.application.port.output.RentalCardOutputPort;
import com.example.rental.application.usecase.InquiryUsecase;
import com.example.rental.framework.web.dto.RentItemOutputDTO;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.ReturnItemOutputDTO;
import com.example.rental.framework.web.dto.UserInputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryInputPort implements InquiryUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    @Override
    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.UserId)
                .map(RentalCardOutputDTO::mapToDTO);
    }

    @Override
    public Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.UserId)
                .map(loadCard -> loadCard.getRentalItemList()
                        .stream()
                        .map(RentItemOutputDTO::mapToDTO)
                        .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.UserId)
                .map(loadCard -> loadCard.getReturnItemLIst()
                        .stream()
                        .map(ReturnItemOutputDTO::mapToDTO)
                        .collect(Collectors.toList()));
    }
}
