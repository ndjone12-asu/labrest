package edu.asu.ser421.labRest_act2.model.exceptions;

import net.minidev.json.JSONObject;

public class SurveyItemRequestIncomplete extends RuntimeException{
    private JSONObject error;
    public SurveyItemRequestIncomplete() {
        this("Survey Item Request Incomplete, missing field");
    }

    public SurveyItemRequestIncomplete(String s) {
        error = new JSONObject();
        error.put("error", s);
    }
    public JSONObject getMessageJSON() {

        return this.error;
    }
}
