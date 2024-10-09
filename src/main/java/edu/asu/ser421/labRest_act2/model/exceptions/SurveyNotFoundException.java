package edu.asu.ser421.labRest_act2.model.exceptions;


import net.minidev.json.JSONObject;

public class SurveyNotFoundException extends RuntimeException{
    private String msg;
    private JSONObject error;
    public SurveyNotFoundException(){
        this("Survey Not Found");
    }

    public SurveyNotFoundException(String s) {
        //super(surveyNotFound);
        error = new JSONObject();
        error.put("error", s);
        //super(msg);
    }

    public JSONObject getMessageJSON() {

        return this.error;
    }
}
