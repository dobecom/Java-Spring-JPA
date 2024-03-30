package com.example.rental.framework.web;

import com.example.rental.application.usecase.*;
import com.example.rental.framework.web.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController {

    private final RentItemUsecase rentItemUsecase;
    private final ReturnItemUsercase returnItemUsercase;
    private final CreateRentalCardUsecase createRentalCardUsecase;
    private final OverdueItemUsercase overdueItemUsercase;
    private final ClearOverdueItemUsecase clearOverdueItemUsecase;
    private final InquiryUsecase inquiryUsecase;
    @Operation(summary = "도서카드 생성",description = "사용자정보 -> 도서카드정보")
    @PostMapping("/RentalCard/")
    public ResponseEntity<RentalCardOutputDTO> createRentalCard(@RequestBody UserInputDTO userInputDTO)
    {
        RentalCardOutputDTO createRentalCard = createRentalCardUsecase.createRentalCard(userInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRentalCard);
    }

    @Operation(summary = "도서카드 조회",description = "사용자정보(id) -> 도서카드정보")
    @GetMapping("/RentalCard/{userId}")
    public ResponseEntity<RentalCardOutputDTO> getRentalCard(@PathVariable String userId){
        Optional<RentalCardOutputDTO> rentalCard = inquiryUsecase.getRentalCard(new UserInputDTO(userId, ""));
        return ResponseEntity.ok(rentalCard.get());
    }
    @Operation(summary = "대여도서목록 조회",description = "사용자정보(id) -> 대여도서목록 조회")
    @GetMapping("/RentalCard/{userId}/rentbook")
    public ResponseEntity<List<RentItemOutputDTO>> getAllRentItem(@PathVariable String userId){
        Optional<List<RentItemOutputDTO>> allRentItem = inquiryUsecase.getAllRentItem(new UserInputDTO(userId, ""));
        return ResponseEntity.ok(allRentItem.get());
    }

    @Operation(summary = "반납도서목록 조회",description = "사용자정보(id) -> 반납도서목록 조회")
    @GetMapping("/RentalCard/{userId}/returnbook")
    public ResponseEntity<List<ReturnItemOutputDTO>> getAllReturnItem(@PathVariable String userId){
        Optional<List<ReturnItemOutputDTO>> allReturnItem = inquiryUsecase.getAllReturnItem(new UserInputDTO(userId, ""));
        return ResponseEntity.ok(allReturnItem.get());
    }

    @Operation(summary = "대여기능",description = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/rent")
    public ResponseEntity<RentalCardOutputDTO> rentItem(@RequestBody UserItemInputDTO userItemInputDTO) throws Exception {
        RentalCardOutputDTO rentalCardOutputDTO = rentItemUsecase.rentItem(userItemInputDTO);
        return ResponseEntity.ok(rentalCardOutputDTO);
    }

    @Operation(summary = "반납기능",description = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/return")
    public ResponseEntity<RentalCardOutputDTO> returnItem(@RequestBody UserItemInputDTO userItemInputDTO) throws Exception {
        RentalCardOutputDTO rentalCardOutputDTO = returnItemUsercase.returnItem(userItemInputDTO);
        return ResponseEntity.ok(rentalCardOutputDTO);
    }

    @Operation(summary = "연체기능",description = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/overdue")
    public ResponseEntity<RentalCardOutputDTO> overdueItem(@RequestBody UserItemInputDTO userItemInputDTO) throws Exception {
        RentalCardOutputDTO rentalCardOutputDTO = overdueItemUsercase.overDueItem(userItemInputDTO);
        return ResponseEntity.ok(rentalCardOutputDTO);
    }

    @Operation(summary = "연체해제기능",description = "사용자정보,포인트 -> 도서카드정보 ")
    @PostMapping("/RentalCard/clearoverdue")
    public ResponseEntity<RentalResultOutputDTO> clearOverdueItem(@RequestBody ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalResultOutputDTO rentalResultOuputDTO = clearOverdueItemUsecase.clearOverdue(clearOverdueInfoDTO);
        return ResponseEntity.ok(rentalResultOuputDTO);
    }

}
