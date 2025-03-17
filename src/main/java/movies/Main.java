package movies;

import movies.exceptions.ReportException;
import movies.models.Customer;
import movies.models.Movie;
import movies.models.Rental;
import movies.models.pricing.ChildrenPrice;
import movies.models.pricing.NewReleasePrice;
import movies.models.pricing.RegularPrice;
import movies.reports.JSONRentalReportDecorator;
import movies.reports.PlainTextRentalReport;
import movies.reports.RentalReport;
import movies.reports.RentalReportDecorator;
import movies.reports.XMLRentalReportDecorator;

public class Main {
    public static void main(String[] args) throws ReportException {
        final Customer customer = new Customer("Test");

        final Movie movie1 = new Movie("Zack Snyder's Justice League", new NewReleasePrice());
        final Movie movie2 = new Movie("Terminator", new RegularPrice());
        final Movie movie3 = new Movie("Soul", new ChildrenPrice());

        customer.addRental(new Rental(movie1, 5));
        customer.addRental(new Rental(movie2, 1));
        customer.addRental(new Rental(movie3, 3));

        final RentalReport plainTextReport = new PlainTextRentalReport();
        final RentalReportDecorator jsonReport = new JSONRentalReportDecorator(plainTextReport);
        final RentalReportDecorator xmlReport = new XMLRentalReportDecorator(jsonReport);
        xmlReport.generateReport(customer);
    }
}
