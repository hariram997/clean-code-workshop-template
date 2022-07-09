package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {
    private String customerName;
    private double totalAmount;
    private int frequentRentalPoints;
    private List<Rental> rentals;

    HtmlStatement(String customerName, double totalAmount, int frequentRentalPoints, List<Rental> rentals) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.frequentRentalPoints = frequentRentalPoints;
        this.rentals = rentals;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + customerName + "</b></h1>";
    }

    private String htmlBody() {
        String htmlStatement = "";
        for (Rental rental : rentals) {
            htmlStatement += "<p>" + rental.title() + " " +
                    rental.amount() + "</p>";
        }
        return htmlStatement;
    }

    private String htmlFooter() {
        String htmlStatement = "";
        htmlStatement += "<p>Amount owed is <b>" + totalAmount + "</b></p>";
        htmlStatement += "<p>You earned <b>" + frequentRentalPoints
                + "</b> frequent renter points</p>";
        return htmlStatement;
    }
}
