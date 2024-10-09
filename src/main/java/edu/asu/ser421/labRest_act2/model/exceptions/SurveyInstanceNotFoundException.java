package edu.asu.ser421.labRest_act2.model.exceptions;

import net.minidev.json.JSONObject;

public class SurveyInstanceNotFoundException extends RuntimeException{
    private JSONObject error;
    public SurveyInstanceNotFoundException() {
        this("Survey Instance Does Not Exist");
    }

    public SurveyInstanceNotFoundException(String s) {
        error = new JSONObject();
        error.put("error", s);
    }
    public JSONObject getMessageJSON() {

        return this.error;
    }
}
