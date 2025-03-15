package movies.models;

import movies.models.pricing.Price;

public class Movie {
    private final String title;
    private final Price price;

    public Movie(final String title, final Price price) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("The movie title can't be null or empty.");
        }

        if (price == null) {
            throw new IllegalArgumentException("The movie price can't be null.");
        }

        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        if (daysRented < 0) {
            throw new IllegalArgumentException("The number of rented days can't be negative.");
        }

        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented < 0) {
            throw new IllegalArgumentException("The number of rented days can't be negative.");
        }

        return price.getFrequentRenterPoints(daysRented);
    }
}
