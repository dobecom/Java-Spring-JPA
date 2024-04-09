package com.example.member.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Email {
    public String address;

    public static Email sample(){
        return new Email("scant10@gmail.com");
    }
}
