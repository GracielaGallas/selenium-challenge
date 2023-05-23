package com.exercise;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String iban;

    public User(String firstName, String lastName, String email, String iban) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.iban = iban;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getIban() {
        return iban;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
