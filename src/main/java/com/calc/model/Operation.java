package com.calc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data @NoArgsConstructor @AllArgsConstructor
public class Operation {
    private double fNum;
    private double sNum;
    private String op;
    private double result;
    private User user;
}
