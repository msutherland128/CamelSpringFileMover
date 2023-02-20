package com.msutherland128.camelspringfilemover.processors;

import com.msutherland128.camelspringfilemover.validators.CSVFileValidator;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CSVFileProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVFileProcessor.class);
    private final CSVFileValidator csvFileValidator;
    private final MessageParser messageParser;


    public CSVFileProcessor(CSVFileValidator csvFileValidator, MessageParser messageParser) {
        this.csvFileValidator = csvFileValidator;
        this.messageParser = messageParser;

    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String csvMessageBody = exchange.getIn().getBody(String.class);

        LOGGER.info("Validating CSV file contents.");
        // Todo - bring in CSVFileValidator and validate contents
        csvFileValidator.validate(csvMessageBody);

        csvMessageBodyManipulator(exchange);

    }

    private void csvMessageBodyManipulator(Exchange exchange) {
        // Customer ID,	Customer Notes,	Address,	DOB,	Gender,	Name
        LOGGER.info("Starting message manipulation on message body.");

        // Todo - split message into an array. Bring in MessageParser & use the message parser method
        String[] csvRows = messageParser.parseCSVContents(exchange.getIn().getBody(String.class));
        String[] updatedCSVRows = new String[csvRows.length];
//        String[] csvColumns = messageParser.parseCSVRow(csvRows[1]);
        StringBuilder builder = new StringBuilder();

        // Todo - concat GP details to customer notes
        for (int i = 0; i < csvRows.length; i++ ) {

            // Ignores the header row
            if (i > 0) {
                System.out.println("Looping message body. Concatenating GP details:");
                String[] csvColumns = messageParser.parseCSVRow(csvRows[i]);
                String customerNotes = csvColumns[1].concat(" Some GP data");

                System.out.println(csvRows[i]);

                for (int j = 0; j < csvColumns.length; j++) {
                    // Inner loop to update the Customer Notes column with customerNotes var
                    if (j == 1) {
                        builder.append(customerNotes);
                        System.out.println(customerNotes);
                        builder.append(",");
                    }
                    builder.append(csvColumns[j]);
                    builder.append(",");
                    System.out.println(csvColumns[j]);
                }
                System.out.println("Print builder: ");
                System.out.println(builder.toString());
                updatedCSVRows[i] = builder.toString();
                builder.setLength(0);

            }

        }

        for (String line : updatedCSVRows) {
            System.out.println(line);
        }

        // Todo - set data to message body
//        String manipulatedCSVMessageBody = csvMessageBody.concat(" - This message has been manipulated by the csvMessageBodyManipulator method.");
//        exchange.getIn().setBody(manipulatedCSVMessageBody);
//        LOGGER.info("Message transformed to: {}.", manipulatedCSVMessageBody);
        LOGGER.info("CSV file processing complete.");

    }
}


