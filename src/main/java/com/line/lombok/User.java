package com.line.lombok;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class User {
    private final Integer id;
    private final String zipCode = "123456";
    private String username;
    private String password;
    @Singular(value = "testHobbies")
    private List<String> hobbies;
}