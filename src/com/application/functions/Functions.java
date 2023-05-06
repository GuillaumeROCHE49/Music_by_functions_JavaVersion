package com.application.functions;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Functions {
    private String function;

    public Functions(String function) {
        this.function = function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public double calculate(float x) {
        // Calcultate the function at x
        Expression e = new ExpressionBuilder(function)
                .variables("x")
                .build()
                .setVariable("x", x);
        return e.evaluate();
    }
}