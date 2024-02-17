package com.ds.applicationforlearnig;

import androidx.annotation.NonNull;

import java.util.Random;

public class Equation extends Constants{
    private float a, b, c;

    public void generateXCoefficients(){
        a = generateRandomNumber();
        b = generateRandomNumber();
        c = generateRandomNumber();
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    private int generateRandomNumber(){
        Random random = new Random();

        return random.nextInt(X_GENERATOR_LIMIT_MAX);
    }

    public boolean isRight(float x1, float x2){
        return ((getA() * Math.pow(x1, 2)) + (getB() * Math.pow(x2, 2)) + getC()) == 0;
    }

    @NonNull
    @Override
    public String toString() {
        return getA() + "x^2 + " + getB() + "b + " + getC();
    }
}
