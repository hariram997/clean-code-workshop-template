package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CustomerTest {

    @Test
    public void test() {
        Customer abc = new Customer("ABC");
        Movie movie0 = new Movie("Movie0", 0);
        Movie movie1 = new Movie("Movie1", 1);
        Movie movie2 = new Movie("Movie2", 2);
        Rental rental0 = new Rental(movie0, 5);
        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 15);
        abc.addRental(rental0);
        abc.addRental(rental1);
        abc.addRental(rental2);

        assertEquals("Rental Record for ABC\n" +
                "\tMovie0\t6.5\n" +
                "\tMovie1\t30.0\n" +
                "\tMovie2\t19.5\n" +
                "Amount owed is 56.0\n" +
                "You earned 4 frequent renter points",abc.statement());
    }

    @Test
    public void shouldReturnCustomerStatement() {
        Customer customer = new Customer("ABC");
        customer.addRental(new Rental(new Movie("movie-1", Movie.REGULAR), 5));
        customer.addRental(new Rental(new Movie("movie-2", Movie.NEW_RELEASE), 5));
        customer.addRental(new Rental(new Movie("movie-3", Movie.CHILDRENS), 5));

        assertEquals("Rental Record for ABC\n" +
                "\tmovie-1\t6.5\n" +
                "\tmovie-2\t15.0\n" +
                "\tmovie-3\t4.5\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points", customer.statement());
    }


}