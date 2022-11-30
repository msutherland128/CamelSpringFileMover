package com.msutherland128.camelspringfilemover.validators;

import com.msutherland128.camelspringfilemover.config.ApplicationProperties;
import com.msutherland128.camelspringfilemover.exceptions.ValidationException;
import com.msutherland128.camelspringfilemover.processors.CSVFileProcessor;
import com.msutherland128.camelspringfilemover.processors.MessageParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CSVFileValidator extends FileValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVFileProcessor.class);
    private final MessageParser messageParser;
    private final ApplicationProperties applicationProperties;

    public CSVFileValidator (final MessageParser messageParser, ApplicationProperties applicationProperties) {
        this.messageParser = messageParser;
        this.applicationProperties = applicationProperties;
    }

    public void validate(String message) throws ValidationException {
        String [] csvRows = messageParser.parseCSVContents(message);
        // Todo - validate that column names are in the correct order and named correctly
        validateColumnHeaders(csvRows[0]);

        // Todo - Create a loop that passes each line of the csv row and send these to the body validator. Don't revalidate 0 index start index of loop at 1.
        // for loop here

    }

    private void validateColumnHeaders(String csvRows) {
        // log csvRows
        LOGGER.info("csvRows logged: " + csvRows);

        // Todo - compare the headers against application properties. Consider using trim/strip methods
        LOGGER.info(applicationProperties.getCsvColumnHeaders());
        String applicationPropertiesCsvColumnHeaders = applicationProperties.getCsvColumnHeaders();

        if (csvRows.equals(applicationPropertiesCsvColumnHeaders)) {
            System.out.println("The csv headers match the application property values");
        }
        else {
            System.out.println("CSV headers do not match application property values");
        }



    }
}
