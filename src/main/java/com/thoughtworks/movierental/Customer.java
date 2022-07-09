package com.thoughtworks.movierental;

public class Customer {
    private final String name;
    private final Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    // rental mutability
    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {

        return new Statement(name, rentals).generate();
    }

    public String htmlStatement() {
        return new HtmlStatement(name, rentals).generate();
    }
}
