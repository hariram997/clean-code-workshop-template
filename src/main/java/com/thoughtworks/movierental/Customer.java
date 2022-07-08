package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRentalPoints = 0;
        String statement = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double amount = rental.amount();

            frequentRentalPoints += rental.frequentPoints();

            //show figures for this rental
            statement += statementFor(rental, amount);
            totalAmount += amount;
        }

        //add footer lines statement
        statement += "Amount owed is " + totalAmount + "\n";
        statement += "You earned " + frequentRentalPoints
                + " frequent renter points";
        return statement;
    }

    private String statementFor(Rental rental, double amount) {
        return "\t" + rental.getMovie().getTitle() + "\t" +
                amount + "\n";
    }

}
