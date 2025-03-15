package movies.models;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(final Movie movie, final int daysRented) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie can't be null.");
        }

        if (daysRented < 0) {
            throw new IllegalArgumentException("The number of rented days can't be negative.");
        }

        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
