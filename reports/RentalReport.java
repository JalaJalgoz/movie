package movies.reports;

import movies.models.Customer;

public interface RentalReport {
    String generateReport(Customer customer);
}
