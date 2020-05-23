package com.demo.exception.custom_execption.demo1;

public class TestCustomException {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18)
            throw new InvalidAgeException("Age is not valid");
        else
            System.out.println("Welcome to vote");
    }


    public static void main(String args[]) {
        try {
            validateAge(13);
        } catch (Exception e) {
            System.out.println("Exception occured: " + e);
        }

        System.out.println("rest of the code...");
    }

}
