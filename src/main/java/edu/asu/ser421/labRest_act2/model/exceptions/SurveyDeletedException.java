package edu.asu.ser421.labRest_act2.model.exceptions;

import net.minidev.json.JSONObject;

public class SurveyDeletedException extends RuntimeException{
    private JSONObject error;
    public SurveyDeletedException(){
        this("Survey marked for deletion, cannot be instatiated or modified");
    }

    public SurveyDeletedException(String s) {
        error = new JSONObject();
        error.put("error", s);
    }
    public JSONObject getMessageJSON() {

        return this.error;
    }
}
