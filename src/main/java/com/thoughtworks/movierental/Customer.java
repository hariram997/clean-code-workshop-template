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
        String statement = "Rental Record for " + getName() + "\n";

        statement += rentalStatement();
        //add footer lines statement
        statement += "Amount owed is " + totalAmount() + "\n";
        statement += "You earned " + frequentRentalPoints()
                + " frequent renter points";
        return statement;
    }

    private String rentalStatement() {
        String statement = "";
        for (Rental rental : rentals) {
            statement += "\t" + rental.title() + "\t" +
                    rental.amount() + "\n";
        }
        return statement;
    }

    private int frequentRentalPoints() {
        int frequentRentalPoints = 0;
        for (Rental rental : rentals) {
            frequentRentalPoints += rental.frequentPoints();

        }
        return frequentRentalPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            double amount = rental.amount();
            totalAmount += amount;
        }
        return totalAmount;
    }

}
