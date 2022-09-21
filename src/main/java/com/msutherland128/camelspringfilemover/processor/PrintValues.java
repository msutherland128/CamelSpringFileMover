package com.msutherland128.camelspringfilemover.processor;

import com.msutherland128.camelspringfilemover.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintValues {

    private ApplicationProperties applicationProperties;

    // Create a constructor which runs a method using variables from application properties

    @Autowired
    public PrintValues(){
        this.applicationProperties = new ApplicationProperties();
        printAllValues();
    }


    private void printAllValues(){
        String inFileValue = applicationProperties.getInFileDirectory();
        String outFileValue = applicationProperties.getOutFileDirectory();

        System.out.println(inFileValue);
        System.out.println(outFileValue);

    }

}
