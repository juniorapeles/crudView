package com.projectTest.vmix.controllers.exeptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError (){
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }
    public void addError( String fieldname, String message ) {
        errors.add(new FieldMessage(fieldname, message));
    }
}
