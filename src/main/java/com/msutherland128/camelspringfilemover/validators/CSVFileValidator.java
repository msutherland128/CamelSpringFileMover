package com.msutherland128.camelspringfilemover.validators;

import com.msutherland128.camelspringfilemover.exceptions.ValidationException;
import com.msutherland128.camelspringfilemover.processors.MessageParser;
import org.springframework.stereotype.Component;

@Component
public class CSVFileValidator extends FileValidator {

    private final MessageParser messageParser;

    public CSVFileValidator (final MessageParser messageParser) {
        this.messageParser = messageParser;
    }

    public void validate(String message) throws ValidationException {
        String [] csvRows = messageParser.parseCSVContents(message);
        // Todo - validate that column names are in the correct order and named correctly
        validateColumnHeaders(csvRows[0]);

        // Todo - Create a loop that passes each line of the csv row and send these to the body validator. Don't revalidate 0 index start index of loop at 1.
        // for loop here
        validateBody(csvRows[1]);
    }

    private void validateColumnHeaders(String columnHeaders) {
        // Todo - log the header and test

        // Todo - compare the headers against application properties. Consider using trim/strip methods

    }
}
