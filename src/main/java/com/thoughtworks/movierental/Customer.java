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
        return new Statement(name, totalAmount(), frequentRentalPoints(), rentals).generate();
    }

    public String htmlStatement() {
        return new HtmlStatement(name, totalAmount(), frequentRentalPoints(), rentals).generate();
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
