package com.msutherland128.camelspringfilemover.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ih")
public class ApplicationProperties {

    // Create application properties variables
    private String inTextFileDirectory;
    private String outTextFileDirectory;
    private String inCSVFileDirectory;
    private String outCSVFileDirectory;


    // getters & setters

    public String getInTextFileDirectory() {
        return inTextFileDirectory;
    }

    public void setInTextFileDirectory(String inFileDirectory) {
        this.inTextFileDirectory = inFileDirectory;
    }

    public String getOutTextFileDirectory() {
        return outTextFileDirectory;
    }

    public void setOutTextFileDirectory(String outTextFileDirectory) {
        this.outTextFileDirectory = outTextFileDirectory;
    }

    public String getInCSVFileDirectory() {
        return inCSVFileDirectory;
    }

    public void setInCSVFileDirectory(String inCSVFileDirectory) {
        this.inCSVFileDirectory = inCSVFileDirectory;
    }

    public String getOutCSVFileDirectory() {
        return outCSVFileDirectory;
    }

    public void setOutCSVFileDirectory(String outCSVFileDirectory) {
        this.outCSVFileDirectory = outCSVFileDirectory;
    }
}


