package movies.reports;

import movies.models.Customer;
import movies.models.Rental;

public class PlainTextRentalReport implements RentalReport {
    @Override
    public String generateReport(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer can't be null.");
        }

        StringBuilder report = new StringBuilder("Rental Record for " + customer.getName() + "\n");
        double totalAmount = 0;
        int rentalPoints = 0;

        for (Rental rental: customer.getRentals()) {
            double charge = rental.getCharge();
            totalAmount = totalAmount + charge;
            rentalPoints = rentalPoints + rental.getFrequentRenterPoints();

            report.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(charge)
                    .append("\n");
        }

        report.append("Amount owed is ").append(totalAmount).append("\n");
        report.append("You earned ").append(rentalPoints).append(" frequent renter points\n");

        System.out.println(report);

        return report.toString();
    }
}
