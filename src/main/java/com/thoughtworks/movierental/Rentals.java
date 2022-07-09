package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    public int frequentRentalPoints() {
        int frequentRentalPoints = 0;
        for (Rental rental : this) {
            frequentRentalPoints += rental.frequentPoints();

        }
        return frequentRentalPoints;
    }

    public double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            double amount = rental.amount();
            totalAmount += amount;
        }
        return totalAmount;
    }

}
