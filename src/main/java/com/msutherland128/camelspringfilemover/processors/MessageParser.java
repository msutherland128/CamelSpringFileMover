package com.msutherland128.camelspringfilemover.processors;

import com.msutherland128.camelspringfilemover.models.JsonModel;
import org.springframework.stereotype.Component;

@Component
public class MessageParser {


    /**
     * @param csvContents - Raw csv file contents
     * @return - Array of csv rows
     */
    public String[] parseCSVContents(String csvContents) {
        return csvContents.split("\n");
    }

    /**
     * @param csvRow - Csv rows
     * @return - Array of csv columns
     */
    public String[] parseCSVRow(String csvRow) {
        return csvRow.split(",");
    }

    /**
     * @param csvContents - Either raw csv contents or csv row
     * @param splitCharacter - Character to split on into an array
     * @return - Array of either columns or rows
     */
    public String[] parseCSV(String csvContents, String splitCharacter) {
        return csvContents.split(splitCharacter);
    }

    public JsonModel parseJsonToPojo(String body) {
        return new JsonModel();
    }



}
