package movies.reports;

import movies.exceptions.ReportException;
import movies.models.Customer;
import movies.models.Rental;
import movies.models.dto.RentalDataDto;
import movies.models.dto.ReportDataDto;

import java.util.ArrayList;
import java.util.List;

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

    protected ReportDataDto getReportDataAsObjectMap(Customer customer) {
        ReportDataDto reportData = new ReportDataDto(customer.getName());

        List<RentalDataDto> rentalList = new ArrayList<>();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : customer.getRentals()) {
            double charge = rental.getCharge();
            final RentalDataDto rentalData = new RentalDataDto(rental.getMovie().getTitle(), charge);

            totalAmount = totalAmount + charge;
            frequentRenterPoints = frequentRenterPoints + rental.getFrequentRenterPoints();
            rentalList.add(rentalData);
        }

        reportData.setRentalList(rentalList);
        reportData.setTotalAmount(totalAmount);
        reportData.setFrequentRenterPoints(frequentRenterPoints);

        return reportData;
    }
}
