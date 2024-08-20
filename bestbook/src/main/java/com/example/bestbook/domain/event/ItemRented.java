package com.example.bestbook.domain.event;


import com.example.bestbook.domain.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemRented implements Serializable {
    private IDName idName;
    private Item item;
    private long point;
}
