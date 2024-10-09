package edu.asu.ser421.labRest_act2.model.exceptions;

import net.minidev.json.JSONObject;

public class SurveyInternalException extends RuntimeException{
    private JSONObject error;
    public SurveyInternalException(){
        this("There was an internal server error");
    }

    public SurveyInternalException(String s) {
        error = new JSONObject();
        error.put("error", s);
    }
    public JSONObject getMessageJSON() {

        return this.error;
    }

}
