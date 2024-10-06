package edu.asu.ser421.labRest_act2.model.exceptions;

public class SurveyItemNotFoundException extends RuntimeException{
    public SurveyItemNotFoundException(){
        this("Survey Item Not Found");
    }

    public SurveyItemNotFoundException(String surveyItemNotFound) {
        super(surveyItemNotFound);
    }
}
