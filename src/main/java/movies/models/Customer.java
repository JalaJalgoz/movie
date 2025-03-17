package movies.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The movie name can't be null or empty.");
        }

        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public void addRental(Rental rental) {
        if (rental == null) {
            throw new IllegalArgumentException("The rental can't be null.");
        }

        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return this.rentals;
    }
}
