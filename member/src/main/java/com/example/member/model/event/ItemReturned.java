package com.example.member.model.event;


import com.example.member.model.vo.IDName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemReturned extends ItemRented{
    public ItemReturned(IDName idName, Item item, long point) {
        super(idName, item, point);
    }
}
