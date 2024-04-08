package com.example.book.model.event;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IDName {
    private String id;
    private String name;

    public static IDName sampe(){
        return new IDName("scant","han");
    }

    public static void main(String[] args){
        System.out.println(sampe().toString());
    }
}
