package edu.asu.ser421.labRest_act2.model.exceptions;

import net.minidev.json.JSONObject;

public class SurveyItemNotFoundException extends RuntimeException{
    private JSONObject error;
    public SurveyItemNotFoundException(){
        this("Survey Item Not Found");
    }

    public SurveyItemNotFoundException(String s) {
        error = new JSONObject();
        error.put("error", s);
    }
    public JSONObject getMessageJSON() {

        return this.error;
    }
}
