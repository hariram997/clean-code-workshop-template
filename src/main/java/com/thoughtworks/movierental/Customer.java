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

        return header() + body() + footer();
    }

    public String htmlStatement() {
        return "<>"+htmlHeader() + htmlBody() + htmlFooter()+"</>";
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + getName() + "</b></h1>";
    }

    private String htmlBody() {
        String htmlStatement = "";
        for (Rental rental : rentals) {
            htmlStatement += "<p>" + rental.title() +" "+
                    rental.amount() + "</p>";
        }
        return htmlStatement;
    }

    private String htmlFooter() {
        String htmlStatement = "";
        htmlStatement += "<p>Amount owed is <b>" + totalAmount() + "</b></p>";
        htmlStatement += "<p>You earned <b>" + frequentRentalPoints()
                + "</b> frequent renter points</p>";
        return htmlStatement;
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private String footer() {
        String statement = "";
        statement += "Amount owed is " + totalAmount() + "\n";
        statement += "You earned " + frequentRentalPoints()
                + " frequent renter points";
        return statement;
    }

    private String body() {
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
