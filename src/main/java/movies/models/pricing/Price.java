package movies.models.pricing;

public interface Price {
    double getCharge(final int daysRented);
    int getFrequentRenterPoints(int daysRented);
}
