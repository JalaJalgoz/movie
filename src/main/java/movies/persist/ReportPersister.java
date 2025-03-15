package movies.persist;

import movies.exceptions.ReportException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportPersister {
    private static final Logger logger = Logger.getLogger(ReportPersister.class.getName());

    public static void persistReportToFile(String report, String fileName) throws ReportException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(report);
            System.out.println("Report save in: " + fileName);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error while persisting report " + fileName, e);
            throw new ReportException("Error while persisting report " + fileName, e);
        }
    }
}
