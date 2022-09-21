package com.msutherland128.camelspringfilemover.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ih")
public class ApplicationProperties {

    // Create application properties variables
    private String inFileDirectory;
    private String outFileDirectory;

    // getters & setters
    public String getInFileDirectory(){
        return inFileDirectory;
    }

    public void setInFileDirectory(final String inFileDirectory){
        this.inFileDirectory = inFileDirectory;

    }

    public String getOutFileDirectory(){
        return outFileDirectory;
    }

    public void setOutFileDirectory(final String outFileDirectory){
        this.outFileDirectory = outFileDirectory;
    }


}


