package com.example.rental.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Item {
    private Integer no;
    private String title;

    public static Item Sample(){
        return new Item(10,"노인과바다");
    }
}
