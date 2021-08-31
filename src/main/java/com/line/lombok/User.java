package com.line.lombok;

import lombok.*;

import java.util.List;

@Builder
@ToString
@Data
public class User {
    private final Integer id;
    private final String zipCode = "123456";
    private String username;
    private String password;
    @Singular(value = "testHobbies")
    private List<String> hobbies;
}