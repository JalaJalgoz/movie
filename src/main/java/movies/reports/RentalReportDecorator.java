package movies.reports;

import movies.exceptions.ReportException;
import movies.models.Customer;
import movies.models.Rental;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class RentalReportDecorator implements RentalReport {
    protected static final String FILE_NAME_FORMAT = "%s%s.%s";
    protected final RentalReport decoratedReport;

    public RentalReportDecorator(final RentalReport decoratedReport) {
        if (decoratedReport == null) {
            throw new IllegalArgumentException("Base report can't be null.");
        }

        this.decoratedReport = decoratedReport;
    }

    @Override
    public String generateReport(Customer customer) throws ReportException {
        return decoratedReport.generateReport(customer);
    }

    protected Map<String, Object> getReportDataAsObjectMap(Customer customer) {
        Map<String, Object> reportData = new LinkedHashMap<>();
        reportData.put("customer", customer.getName());

        List<Map<String, Object>> rentalList = new ArrayList<>();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : customer.getRentals()) {
            Map<String, Object> rentalData = new LinkedHashMap<>();
            rentalData.put("movie", rental.getMovie().getTitle());
            double charge = rental.getCharge();
            rentalData.put("charge", charge);
            totalAmount = totalAmount + charge;
            frequentRenterPoints = frequentRenterPoints + rental.getFrequentRenterPoints();
            rentalList.add(rentalData);
        }

        reportData.put("rentals", rentalList);
        reportData.put("totalAmount", totalAmount);
        reportData.put("frequentRenterPoints", frequentRenterPoints);

        return reportData;
    }
}
