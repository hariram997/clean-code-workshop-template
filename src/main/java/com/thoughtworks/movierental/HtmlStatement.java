package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {
    private String customerName;

    private Rentals rentals;

    HtmlStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
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
        htmlStatement += "<p>Amount owed is <b>" + rentals.totalAmount() + "</b></p>";
        htmlStatement += "<p>You earned <b>" + rentals.frequentRentalPoints()
                + "</b> frequent renter points</p>";
        return htmlStatement;
    }
}
