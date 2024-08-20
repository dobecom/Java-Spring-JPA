package com.example.rental.application.port.input;

import com.example.rental.application.port.output.EventOutputPort;
import com.example.rental.application.port.output.RentalCardOutputPort;
import com.example.rental.application.usecase.CompensationUsecase;
import com.example.rental.domain.RentalCard;
import com.example.rental.domain.event.PointUseCommand;
import com.example.rental.domain.vo.IDName;
import com.example.rental.domain.vo.Item;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class CompensationInputPort implements CompensationUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCard cancelRentItem(IDName idName, Item item) {

        return rentalCardOutputPort.loadRentalCard(idName.getId())
                .map(rentalCard -> {
                    try {
                        rentalCard.cancelRentItem(item);
                        eventOutputPort.occurPointUseCommand(new PointUseCommand(idName,10L));
                        return rentalCard;
                    } catch (Exception e){
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new NoSuchElementException("RentalCard not found for ID" + idName.getId()));
    }

    @Override
    public RentalCard cancelReturnItem(IDName idName, Item item, long point) {
        return rentalCardOutputPort.loadRentalCard(idName.getId())
                .map(rentalCard -> {
                    try {
                        rentalCard.cancelReturnItem(item, point);
                        eventOutputPort.occurPointUseCommand(new PointUseCommand(idName, point));
                        return rentalCard;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new NoSuchElementException("Rental card not found for ID: " + idName.getId()));
    }
    @Override
    public long cancelMakeAvailableRental(IDName idName, long point) {
        return rentalCardOutputPort.loadRentalCard(idName.getId())
                .map(rentalCard -> {
                    try {
                        return rentalCard.cancelMakeAvailableRental(point);
                        // 별도로 포인트 사용취소를 보상하기위한 이벤트는 발행하지 않음.
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new NoSuchElementException("Rental card not found for ID: " + idName.getId()));
    }
}
