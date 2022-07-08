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
        int frequentRenterPoints = 0;
        String statement = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double amount = rental.amount();

            // add frequent renter points
            frequentRenterPoints++;

            if (rental.additionalBonus()) frequentRenterPoints++;

            //show figures for this rental
            statement += "\t" + rental.getMovie().getTitle() + "\t" +
                    amount + "\n";
            totalAmount += amount;
        }

        //add footer lines statement
        statement += "Amount owed is " + totalAmount + "\n";
        statement += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return statement;
    }

}
