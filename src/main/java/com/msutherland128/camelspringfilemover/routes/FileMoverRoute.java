package com.msutherland128.camelspringfilemover.routes;

import com.msutherland128.camelspringfilemover.config.ApplicationProperties;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileMoverRoute extends RouteBuilder {

    private ApplicationProperties applicationProperties;

    public FileMoverRoute(ApplicationProperties applicationProperties){
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void configure() throws Exception {

        from(applicationProperties.getInTextFileDirectory())
                // Todo - research labels
                //.id("textFileRoute")
                .to(applicationProperties.getOutTextFileDirectory());

        // todo - complete route for csv files
//        from(applicationProperties.getInTextFileDirectory());
    }
}
