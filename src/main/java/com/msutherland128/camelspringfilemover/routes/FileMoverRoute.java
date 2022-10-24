package com.msutherland128.camelspringfilemover.routes;

import com.msutherland128.camelspringfilemover.config.ApplicationProperties;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileMoverRoute extends RouteBuilder {

    private ApplicationProperties applicationProperties;
    private int counter = 0;

    public FileMoverRoute(ApplicationProperties applicationProperties){
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void configure() throws Exception {

        from(applicationProperties.getInTextFileDirectory())
                .log(LoggingLevel.INFO, "Received message with body: ${body}")
                .setHeader("testHeader", simple("1234"))
                .process(exchange -> {
                    exchange.getIn().setHeader("counter", counter++);
                    exchange.setProperty("testProperty", "testPropertyValue");
                })
                .log(LoggingLevel.INFO, "${headers}")
                .log(LoggingLevel.INFO, "Number of files received is: ${header.counter}")
                .log(LoggingLevel.INFO, "Message property is: " + exchangeProperty("testProperty"))
                // Todo - research labels
                //.id("textFileRoute")
                // Todo - investigate issue with debug logging low priority
                .log(LoggingLevel.DEBUG, "Sending file to: {}", applicationProperties.getOutTextFileDirectory())
                .to(applicationProperties.getOutTextFileDirectory());

        // todo - complete route for csv files
//        from(applicationProperties.getInTextFileDirectory());
    }
}
