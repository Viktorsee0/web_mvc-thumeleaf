package com.calc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    private int id;

    @NotEmpty
    private String name;

    @Size(min = 3,max = 20)
    @NotEmpty
    private String login;

    @Size(min = 3,max = 20)
    @NotEmpty
    private String password;
}
