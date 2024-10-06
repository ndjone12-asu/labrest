package edu.asu.ser421.labRest_act2.model.exceptions;

public class SurveyDeletedException extends RuntimeException{
    public SurveyDeletedException(){
        this("Survey marked for deletion, cannot be instatiated or modified");
    }

    public SurveyDeletedException(String surveyMarkedForDeletion) {
        super(surveyMarkedForDeletion);
    }
}
