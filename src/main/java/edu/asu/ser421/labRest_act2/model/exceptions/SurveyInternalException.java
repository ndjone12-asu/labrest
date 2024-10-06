package edu.asu.ser421.labRest_act2.model.exceptions;

public class SurveyInternalException extends RuntimeException{
    public SurveyInternalException(){
        this("There was an internal server error");
    }

    public SurveyInternalException(String s) {
        super(s);
    }

}
