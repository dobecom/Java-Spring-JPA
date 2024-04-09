package com.example.member.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PassWord {
    public String presentPWD;
    public String pastPWD;

    public static PassWord sample(){
        return new PassWord("12345","abcde");
    }
}
