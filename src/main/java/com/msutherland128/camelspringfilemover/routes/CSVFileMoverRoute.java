package com.msutherland128.camelspringfilemover.routes;

import com.msutherland128.camelspringfilemover.config.ApplicationProperties;
import com.msutherland128.camelspringfilemover.processors.CSVFileProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CSVFileMoverRoute extends RouteBuilder {

    private final ApplicationProperties applicationProperties;
    private final CSVFileProcessor csvFileProcessor;
    private int counter = 0;

    public CSVFileMoverRoute(final ApplicationProperties applicationProperties, final CSVFileProcessor csvFileProcessor){
        this.applicationProperties = applicationProperties;
        this.csvFileProcessor = csvFileProcessor;
    }

    @Override
    public void configure() throws Exception {

        from(applicationProperties.getInCSVFileDirectory())
                // Todo - research ids
                .id("csvFileConsumerRoute")
                .convertBodyTo(String.class)
                .log(LoggingLevel.INFO, "File received on csvFileConsumerRoute.")
                .filter()
                .simple("${file:ext} == '" + applicationProperties.getFileExtension().get(0) + "'")
                .log(LoggingLevel.INFO, "Received message with body: ${body}")
                .setHeader("testHeader", simple("1234"))
                .process(exchange -> {
                    exchange.getIn().setHeader("counter", ++counter);
                    exchange.setProperty("testProperty", "testPropertyValue");
                })
                .log(LoggingLevel.INFO, "Sending to CSVFileProcessor.")
                .process(csvFileProcessor)
                .log(LoggingLevel.INFO, "${headers}")
                .log(LoggingLevel.INFO, "Number of files received is: ${header.counter}")
                .log(LoggingLevel.INFO, "Message property is: " + exchangeProperty("testProperty"))
                // Todo - investigate issue with debug logging low priority
                .log(LoggingLevel.DEBUG, "Sending file to: {}", applicationProperties.getOutFileDirectory())
                .to(applicationProperties.getOutFileDirectory());

        // todo - complete route for csv files
//        from(applicationProperties.getInTextFileDirectory());
    }
}
