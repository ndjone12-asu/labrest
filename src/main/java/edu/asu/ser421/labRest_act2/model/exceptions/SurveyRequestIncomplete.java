package edu.asu.ser421.labRest_act2.model.exceptions;

import net.minidev.json.JSONObject;

public class SurveyRequestIncomplete extends RuntimeException{
    private JSONObject error;
    public SurveyRequestIncomplete() {
        this("Survey Request Incomplete, missing field");
    }

    public SurveyRequestIncomplete(String s) {
        error = new JSONObject();
        error.put("error", s);
    }

    public JSONObject getMessageJSON() {

        return this.error;
    }
}
