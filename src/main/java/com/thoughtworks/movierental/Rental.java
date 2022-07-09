package com.thoughtworks.movierental;

public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double amount(){
        return movie.amount(daysRented);
    }

    private boolean additionalBonus() {
        return (movie.getPriceCode() == Movie.NEW_RELEASE)
                &&
                daysRented > 1;
    }

    public int frequentPoints() {

        if (additionalBonus()) return 2;
        return 1;
    }

    public String title() {
        return movie.getTitle();
    }
}