package com.example.rental.application.port.output;

import com.example.rental.domain.event.ItemRented;
import com.example.rental.domain.event.ItemReturned;
import com.example.rental.domain.event.OverdueCleared;
import com.example.rental.domain.event.PointUseCommand;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface EventOutputPort {
    public void occurRentalEvent(ItemRented itemRented) throws JsonProcessingException;
    public void occurReturnEvent(ItemReturned itemReturned) throws JsonProcessingException;
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException;

    void occurPointUseCommand(PointUseCommand pointUseCommand);
}
