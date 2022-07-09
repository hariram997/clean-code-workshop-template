package com.thoughtworks.movierental;

class Statement {

    private String customerName;
    private final Rentals rentals;

    Statement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
    }

    private String body() {
       // rentals.add(new Rental(new Movie("Movie 2",0),5));

        String statement = "";
        for (Rental rental : rentals) {
            statement += "\t" + rental.title() + "\t" +
                    rental.amount() + "\n";
        }
        return statement;
    }

    private String footer() {
        String statement = "";
        statement += "Amount owed is " + rentals.totalAmount() + "\n";
        statement += "You earned " + rentals.frequentRentalPoints()
                + " frequent renter points";
        return statement;
    }
}
