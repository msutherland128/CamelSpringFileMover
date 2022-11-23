package com.msutherland128.camelspringfilemover.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("ih")
public class ApplicationProperties {

    // Create application properties variables
    private String inTextFileDirectory;
    private String outFileDirectory;
    private String inCSVFileDirectory;
    private List<String> fileExtension;


    // getters & setters

    public String getInTextFileDirectory() {
        return inTextFileDirectory;
    }

    public void setInTextFileDirectory(String inFileDirectory) {
        this.inTextFileDirectory = inFileDirectory;
    }

    public String getInCSVFileDirectory() {
        return inCSVFileDirectory;
    }

    public void setInCSVFileDirectory(String inCSVFileDirectory) {
        this.inCSVFileDirectory = inCSVFileDirectory;
    }

    public String getOutFileDirectory() {
        return outFileDirectory;
    }

    public void setOutFileDirectory(String outFileDirectory) {
        this.outFileDirectory = outFileDirectory;
    }

    public List<String> getFileExtension(){
        return fileExtension;
    }

    public void setFileExtension(final List<String> fileExtension){
        this.fileExtension = fileExtension;
    }
}



