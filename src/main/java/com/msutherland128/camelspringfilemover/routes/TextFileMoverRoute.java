package com.msutherland128.camelspringfilemover.routes;

import com.msutherland128.camelspringfilemover.config.ApplicationProperties;
import com.msutherland128.camelspringfilemover.processor.TextFileProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TextFileMoverRoute extends RouteBuilder {

    private final ApplicationProperties applicationProperties;
    private final TextFileProcessor textFileProcessor;
    private int counter = 0;

    public TextFileMoverRoute(final ApplicationProperties applicationProperties, final TextFileProcessor textFileProcessor){
        this.applicationProperties = applicationProperties;
        this.textFileProcessor = textFileProcessor;
    }

    @Override
    public void configure() throws Exception {

        from(applicationProperties.getInTextFileDirectory())
                .id("textFileConsumerRoute")
                .filter()
                .simple("${file:ext}== '" + applicationProperties.getFileExtension().get(1) + "'")
                .log(LoggingLevel.INFO, "Received message with body: ${body}")
                .setHeader("testHeader", simple("1234"))
                .process(exchange -> {
                    exchange.getIn().setHeader("counter", ++counter);
                    exchange.setProperty("testProperty", "Testing specific Property value.");
                })
                .process(textFileProcessor)
                .log(LoggingLevel.INFO, "${headers}")
                .log(LoggingLevel.INFO, "Number of files received is: ${header.counter}")
                .log(LoggingLevel.INFO, "Message property is: " + exchangeProperty("testProperty"))
                // Todo - investigate issue with debug logging low priority
                .log(LoggingLevel.INFO, "Sending file to: {}", applicationProperties.getOutFileDirectory())
                .to(applicationProperties.getOutFileDirectory());

    }
}
