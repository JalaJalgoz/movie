package movies.reports;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import movies.exceptions.ReportException;
import movies.models.Customer;
import movies.persist.ReportPersister;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLRentalReportDecorator extends RentalReportDecorator {
    private static final Logger logger = Logger.getLogger(XMLRentalReportDecorator.class.getName());
    private final String EXTENSION = "xml";
    private final XmlMapper xmlMapper = new XmlMapper();

    public XMLRentalReportDecorator(RentalReport decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public String generateReport(Customer customer) throws ReportException {
        if (customer == null) {
            throw new ReportException("Customer can't be null.");
        }
        try {
            decoratedReport.generateReport(customer);
            Map<String, Object> reportData = getReportDataAsObjectMap(customer);

            // Serializar XML
            String xmlReport = xmlMapper
                    .writer()
                    .withRootName("report")
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(reportData);
            // Persist report
            final long currentMillis = System.currentTimeMillis();
            final String fileName = String.format(FILE_NAME_FORMAT, customer.getName(), currentMillis, EXTENSION);
            ReportPersister.persistReportToFile(xmlReport, fileName);
            return xmlReport;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IO error while generating or persisting the JSON report", e);
            throw new ReportException("IO error while generating or persisting the JSON report: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error while generating or persisting the JSON report", e);
            throw new ReportException("Unexpected error while generating or persisting the JSON report: " + e.getMessage(), e);
        }
    }
}
