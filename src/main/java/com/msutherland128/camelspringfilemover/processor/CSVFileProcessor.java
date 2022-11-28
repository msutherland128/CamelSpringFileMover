package com.msutherland128.camelspringfilemover.processor;

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
    // Todo - create csv processor add logging and consider business use of logging data
        String csvMessageBody = exchange.getIn().getBody(String.class);
        csvMessageBodyManipulator(exchange, csvMessageBody);

    }

    public void csvMessageBodyManipulator(Exchange exchange, String csvMessageBody) {
        LOGGER.info("Starting message manipulation on message body.");
        String manipulatedCSVMessageBody = csvMessageBody.concat(" - This message has been manipulated by the csvMessageBodyManipulator method.");
        exchange.getIn().setBody(manipulatedCSVMessageBody);
        LOGGER.info("Message transformed to: {}.", manipulatedCSVMessageBody);
        LOGGER.info("CSV file processing complete.");

    }
}


