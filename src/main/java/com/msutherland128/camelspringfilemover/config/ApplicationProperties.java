package com.msutherland128.camelspringfilemover.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ih")
public class ApplicationProperties {

    // Create application properties variables
    private String inFileDirectory;
    // todo - update var to outtextfile
    private String outFileDirectory;
    // todo - add new var for outcsvfile

    // todo - add getters/setters for outcsv var

    // getters & setters
    public String getInFileDirectory() {
        return inFileDirectory;
    }

    public void setInFileDirectory(String inFileDirectory) {
        this.inFileDirectory = inFileDirectory;
    }

    public String getOutFileDirectory() {
        return outFileDirectory;
    }

    public void setOutFileDirectory(String outFileDirectory) {
        this.outFileDirectory = outFileDirectory;
    }





}


