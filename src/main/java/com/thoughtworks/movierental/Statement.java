package com.thoughtworks.movierental;

import java.util.List;

class Statement {

    private String customerName;
    private double totalAmount;
    private int frequentRentalPoints;
    private List<Rental> rentals;

    Statement(String customerName, double totalAmount, int frequentRentalPoints, List<Rental> rentals) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.frequentRentalPoints = frequentRentalPoints;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
    }

    private String body() {
        String statement = "";
        for (Rental rental : rentals) {
            statement += "\t" + rental.title() + "\t" +
                    rental.amount() + "\n";
        }
        return statement;
    }

    private String footer() {
        String statement = "";
        statement += "Amount owed is " + totalAmount + "\n";
        statement += "You earned " + frequentRentalPoints
                + " frequent renter points";
        return statement;
    }
}
