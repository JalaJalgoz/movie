package movies.models.pricing;

import movies.utils.PricingConstants;

public class RegularPrice implements Price {
    private static final double LIMIT_DAYS_RENTED = 2;
    private static final double PRICE = 2;

    @Override
    public double getCharge(int daysRented) {
        double charge = PRICE;

        if (daysRented > LIMIT_DAYS_RENTED) {
            charge += (daysRented - LIMIT_DAYS_RENTED) * PricingConstants.MULTIPLYING_FACTOR;
        }

        return charge;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return PricingConstants.ZERO_FREQUENT_RENTER_POINTS;
    }
}
