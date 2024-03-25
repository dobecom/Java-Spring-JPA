package com.example.rental.framework.web;

//import com.example.rental.application.usecase.InquiryUsecase;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RentalController {
//    private final InquiryUsecase inquiryUsecase;
//    @GetMapping()
//    public ResponseEntity<RentalCardOutputDTO> getRentalCard(@PathVariable String userId){
//        Optional<RentalCardOutputDTO> rentalCard = inquiryUsecase.getRentalCard(new UserInputDTO(userId, ""));
//        return ResponseEntity.ok(rentalCard.get());
//    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
