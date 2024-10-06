package edu.asu.ser421.labRest_act2.model.exceptions;


public class SurveyNotFoundException extends RuntimeException{
    public SurveyNotFoundException(){
        this("Survey Not Found");
    }

    public SurveyNotFoundException(String surveyNotFound) {
        super(surveyNotFound);
    }
}
