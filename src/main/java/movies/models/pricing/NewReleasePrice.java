package movies.models.pricing;

import movies.utils.PricingConstants;

public class NewReleasePrice implements Price {
    private static final double LIMIT_DAYS_RENTED = 1;
    private static final double PRICE = 3;

    @Override
    public double getCharge(int daysRented) {
        return daysRented * PRICE;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > LIMIT_DAYS_RENTED) ?
                PricingConstants.MAX_FREQUENT_RENTER_POINTS :
                PricingConstants.NORMAL_FREQUENT_RENTER_POINTS;
    }
}
