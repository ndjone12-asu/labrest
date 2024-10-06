package edu.asu.ser421.labRest_act2.api.modelhelpers;

public class SurveyInstanceRequest {
    public SurveyInstanceRequest(){}
    public SurveyInstanceRequest(String user, String surveyName) {

    }
    public String getSurveyName(){
        return __surveyName;
    }
    public String getUser(){
        return __user;
    }

    public void setSurveyName(String surveyName){
        __surveyName = surveyName;
    }
    public void setUser(String name) {
        __user = name;
    }
    private String __user;
    private String __surveyName;
}
