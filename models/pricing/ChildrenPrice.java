package movies.models.pricing;

public class ChildrenPrice implements Price {
    @Override
    public double getCharge(int daysRented) {
        double charge = 1.5;

        if (daysRented > 3) {
            charge = charge + (daysRented - 3) * 1.5;
        }

        return charge;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
