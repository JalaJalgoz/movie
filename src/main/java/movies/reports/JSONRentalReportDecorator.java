package movies.reports;

import com.fasterxml.jackson.databind.ObjectMapper;
import movies.exceptions.ReportException;
import movies.models.Customer;
import movies.models.dto.ReportDataDto;
import movies.persist.ReportPersister;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONRentalReportDecorator extends RentalReportDecorator {
    private static final Logger logger = Logger.getLogger(JSONRentalReportDecorator.class.getName());
    private final String EXTENSION = "json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JSONRentalReportDecorator(final RentalReport decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public String generateReport(Customer customer) throws ReportException {
        if (customer == null) {
            throw new ReportException("Customer can't be null.");
        }
        try {
            // We call the previous report decorator
            decoratedReport.generateReport(customer);
            final ReportDataDto reportData = getReportDataAsObjectMap(customer);

            // Serializar JSON
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reportData);

            // Persist json
            final long currentMillis = System.currentTimeMillis();
            final String fileName = String.format(FILE_NAME_FORMAT, customer.getName(), currentMillis, EXTENSION);
            ReportPersister.persistReportToFile(jsonReport, fileName);
            return jsonReport;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IO error while generating or persisting the JSON report", e);
            throw new ReportException("IO error while generating or persisting the JSON report: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error while generating or persisting the JSON report", e);
            throw new ReportException("Unexpected error while generating or persisting the JSON report: " + e.getMessage(), e);
        }
    }
}
