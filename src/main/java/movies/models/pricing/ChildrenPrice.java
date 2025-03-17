package movies.models.pricing;

import movies.utils.PricingConstants;

public class ChildrenPrice implements Price {
    private static final double LIMIT_DAYS_RENTED = 3;
    private static final double PRICE = 1.5;

    @Override
    public double getCharge(int daysRented) {
        double charge = PRICE;

        if (daysRented > LIMIT_DAYS_RENTED) {
            charge = charge + (daysRented - LIMIT_DAYS_RENTED) * PricingConstants.MULTIPLYING_FACTOR;
        }

        return charge;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return PricingConstants.NORMAL_FREQUENT_RENTER_POINTS;
    }
}
