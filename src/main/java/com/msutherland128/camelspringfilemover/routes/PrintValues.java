package com.msutherland128.camelspringfilemover.routes;

import com.msutherland128.camelspringfilemover.config.ApplicationProperties;
import org.springframework.stereotype.Component;

@Component
public class PrintValues {

    private ApplicationProperties applicationProperties;

    // Create a constructor which runs a method using variables from application properties

    public PrintValues(ApplicationProperties applicationProperties){
        this.applicationProperties = applicationProperties;
        printAllValues();
    }


    private void printAllValues(){
        System.out.println(applicationProperties.getInTextFileDirectory());
        System.out.println(applicationProperties.getOutFileDirectory());

    }

}
