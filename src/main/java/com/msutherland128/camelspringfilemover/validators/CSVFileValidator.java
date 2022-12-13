package com.msutherland128.camelspringfilemover.validators;

import com.msutherland128.camelspringfilemover.config.ApplicationProperties;
import com.msutherland128.camelspringfilemover.exceptions.ValidationException;
import com.msutherland128.camelspringfilemover.processors.CSVFileProcessor;
import com.msutherland128.camelspringfilemover.processors.MessageParser;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
        String[] csvRows = messageParser.parseCSVContents(message);

        // Todo - validate that column names are in the correct order and named correctly

        validateColumnHeaders(csvRows[0]);

        // Todo - Create a loop that passes each line of the csv row and send these to the body validator. Don't revalidate 0 index start index of loop at 1.
        // for loop here

    }

    private void validateColumnHeaders(String headerRow) {
        // log csvRows
        System.out.println(headerRow);
        System.out.println();
        System.out.println(applicationProperties.getCsvColumnHeaders());
        System.out.println();
        LOGGER.info("csvRows logged: " + headerRow);

        // Testing output of object type
        LOGGER.info(headerRow.getClass().getName());

        // Testing output of get method
        LOGGER.info("getCsvColumnHeaders logged: " + applicationProperties.getCsvColumnHeaders());

        // Todo - Ask Grant if csvColumnHeaders should be converted to String array list within  method so column order can be compared

        // Todo - compare the headers against application properties. Consider using trim/strip methods

        // Todo - call private strip method here pass headerRow & applicationproperties getter

        if (headerRow
                .strip()
                .trim().replaceAll("\n","")
                    .replaceAll("\r","")
                    .replaceAll("\t","")
                    .replaceAll("\\s", "")
                    .replaceAll("\uFEFF", "")
                .equalsIgnoreCase(applicationProperties.getCsvColumnHeaders()
                        .strip()
                        .trim()
                        .replaceAll("\n","")
                                .replaceAll("\r","")
                                .replaceAll("\t","")
                                .replaceAll("\\s", "")
                                .replaceAll("\uFEFF", "")
                )) {
            LOGGER.info("Validated successfully.");

        } else {
            LOGGER.info("Validation failed.");
        }

    }

    // Todo - Put all of the strip / trim in from validateColumnHeaders method into private method here
}
