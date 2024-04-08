package com.example.book.model.event;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
