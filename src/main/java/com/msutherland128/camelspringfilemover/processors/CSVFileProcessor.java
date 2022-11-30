package com.msutherland128.camelspringfilemover.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CSVFileProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVFileProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String csvMessageBody = exchange.getIn().getBody(String.class);

        // Todo - bring in CSVFileValidator and validate contents

        csvMessageBodyManipulator(exchange, csvMessageBody);

    }

    private void csvMessageBodyManipulator(Exchange exchange, String csvMessageBody) {
        // Customer ID	Customer Notes	Address	DOB	Gender	Name
        LOGGER.info("Starting message manipulation on message body.");

        // Todo - split message into an array. Bring in MessageParser & use the message parser method

        // Todo - concat GP details to customer notes

        // Todo - set data to message body
//        String manipulatedCSVMessageBody = csvMessageBody.concat(" - This message has been manipulated by the csvMessageBodyManipulator method.");
//        exchange.getIn().setBody(manipulatedCSVMessageBody);
//        LOGGER.info("Message transformed to: {}.", manipulatedCSVMessageBody);
        LOGGER.info("CSV file processing complete.");

    }
}


