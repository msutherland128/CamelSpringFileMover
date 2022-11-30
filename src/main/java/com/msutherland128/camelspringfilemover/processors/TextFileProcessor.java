package com.msutherland128.camelspringfilemover.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TextFileProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextFileProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.info(exchange.getIn().getMessageId());
        LOGGER.info(exchange.getIn().getBody(String.class));
        LOGGER.info(String.valueOf(exchange.getProperties()));
        LOGGER.info(exchange.getProperty("testProperty", String.class));
        LOGGER.info(String.valueOf(exchange.getIn().getHeaders()));
        LOGGER.info(exchange.getIn().getHeader("counter", String.class));

        String messageBody = exchange.getIn().getBody(String.class);
        messageBodyManipulator(exchange, messageBody);

    }
    
    public void messageBodyManipulator(Exchange exchange, String messageBody) {
        String alteredMessageBody = messageBody.concat(" - This message body has been altered by the messageBodyManipulator method.");
        exchange.getIn().setBody(alteredMessageBody);
        LOGGER.info("Message transformed to: {}", alteredMessageBody);
        LOGGER.info("Text file processing complete.");
    }
}
