package edu.asu.ser421.labRest_act2.model.exceptions;

import net.minidev.json.JSONObject;

import java.security.PublicKey;

public class SurveyFullException extends RuntimeException {
    private JSONObject error;
    public SurveyFullException(){
        this("Survey already has max items");
    }

    public SurveyFullException(String s) {
        error = new JSONObject();
        error.put("error", s);
    }
    public JSONObject getMessageJSON() {

        return this.error;
    }
}
