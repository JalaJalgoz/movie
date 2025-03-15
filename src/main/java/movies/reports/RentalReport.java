package movies.reports;

import movies.exceptions.ReportException;
import movies.models.Customer;

public interface RentalReport {
    String generateReport(Customer customer) throws ReportException;
}
