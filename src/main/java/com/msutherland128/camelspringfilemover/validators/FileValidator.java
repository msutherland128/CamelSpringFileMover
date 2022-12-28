package com.msutherland128.camelspringfilemover.validators;

import com.msutherland128.camelspringfilemover.exceptions.ValidationException;

public abstract class FileValidator {

    // Todo - validate contents of all types to ensure no malicious chars are contained
    public void validateBody(String body) throws ValidationException {

    }


}
