package edu.asu.ser421.labRest_act2.model.exceptions;

import java.security.PublicKey;

public class SurveyFullException extends RuntimeException {
    public SurveyFullException(){
        this("Survey already has max items");
    }

    public SurveyFullException(String surveyAlreadyHasMaxItems) {
        super(surveyAlreadyHasMaxItems);
    }
}
