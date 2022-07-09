package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public double amount(int daysRented) {
        double amount = 0;
        switch (getPriceCode()) {
            case REGULAR:
                return regularMovieAmount(daysRented);
            case NEW_RELEASE:
                return newMovieAmount(daysRented);
            case CHILDRENS:
                return childrenMovieAmount(daysRented);
        }
        return amount;
    }

    private double childrenMovieAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    private double newMovieAmount(int daysRented) {
        double amount = daysRented * 3;
        return amount;
    }

    private double regularMovieAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }
}