package movies.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public void addRental(List<Rental> rental) {
        rentals.addAll(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return this.rentals;
    }
}
