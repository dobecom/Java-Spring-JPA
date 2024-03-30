package com.example.rental.domain;

import com.example.rental.domain.vo.Item;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RentalItem {
   @Embedded
   private Item item;
   private LocalDate rentDate;

   private boolean overdued;

   private LocalDate overdueDate; //반납예정일

   public static RentalItem createRentalItem(Item item)
   {
    return new RentalItem(item,LocalDate.now(),false,LocalDate.now().plusDays(14));
   }

   public static RentalItem sample(){
    return RentalItem.createRentalItem(Item.Sample());
   }
}
