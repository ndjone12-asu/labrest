package edu.asu.ser421.labRest_act2.model;

import java.util.ArrayList;

public class Survey {
    private ArrayList<SurveyItem> surveyItems;
    private String state;
    private String surveyName;

    public Survey(String name) {
        surveyName = name;
        surveyItems = new ArrayList<>();
        state = "created";
    }

    public String getState() {
        return state;
    }

    public ArrayList<SurveyItem> getSurveyItems() {
        return surveyItems;
    }

    public void addSurveyItem(SurveyItem surveyItem) {
        surveyItems.add(surveyItem);
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSurveyName(){
        return surveyName;
    }

    public void setSurveyName(String name) {
        surveyName = name;
    }

}
