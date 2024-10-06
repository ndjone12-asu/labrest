package edu.asu.ser421.labRest_act2.api.modelhelpers;

import edu.asu.ser421.labRest_act2.model.SurveyItem;

import java.util.ArrayList;

public class SurveyRequest {
    public SurveyRequest() {

    }
    public SurveyRequest(String surveyName, ArrayList<SurveyItem> surveyItems, String state) {

    }
    public String getSurveyName(){
        return __surveyName;
    }
    public ArrayList<SurveyItem> getSurveyItems(){
        return __surveyItems;
    }
    public String getState(){
        return __state;
    }

    public void setSurveyName(String name) {
        __surveyName = name;
    }
    public void setSurveyItems(ArrayList<SurveyItem> surveyItems) {
        __surveyItems = surveyItems;
    }
    public void setState(String state) {
        __state = state;
    }
    private String __surveyName;
    private ArrayList<SurveyItem> __surveyItems;
    private String __state;
}
