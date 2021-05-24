package com.calc.model;

import org.springframework.stereotype.Component;

@Component
public class Sub implements Action{

    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}
