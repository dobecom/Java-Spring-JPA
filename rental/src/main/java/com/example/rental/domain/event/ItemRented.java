package com.example.rental.domain.event;

import com.example.rental.domain.vo.IDName;
import com.example.rental.domain.vo.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ItemRented implements Serializable {
    private IDName idName;
    private Item item;
    private long point;
}
