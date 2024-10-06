package edu.asu.ser421.labRest_act2.model;

import java.util.ArrayList;

public class SurveyInstance extends Survey {
    private String surveyInstanceName;
    private String user;
    private String state;
    private ArrayList<SurveyItemInstance> surveyItemInstances;
    public SurveyInstance(String name, String user, Survey survey) {
        super(name);
        this.surveyInstanceName = setSurveyInstanceName(name);
        this.user = user;
        this.state = "created";
        this.surveyItemInstances = surveyItemsToInstances(survey);
    }

    private ArrayList<SurveyItemInstance> surveyItemsToInstances(Survey survey) {
        ArrayList<SurveyItemInstance> itemInstances = new ArrayList<>();
        for(SurveyItem s : survey.getSurveyItems()) {
            SurveyItemInstance sii = new SurveyItemInstance(s);
            itemInstances.add(sii);
        }
        return itemInstances;
    }

    public String getSurveyInstanceName(){
        return surveyInstanceName;
    }
    public String getUser() {
        return user;
    }

    @Override
    public String getState() {
        return state;
    }
    public ArrayList<SurveyItemInstance> getSurveyItemInstances(){
        return surveyItemInstances;
    }
    public String setSurveyInstanceName(String instanceName) {
        this.surveyInstanceName = instanceName;
        return this.surveyInstanceName;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }
    public void setSurveyItemInstances(ArrayList<SurveyItemInstance> surveyItemInstances) {
        this.surveyItemInstances = surveyItemInstances;
    }

    public boolean isCompleted() {
        for(SurveyItemInstance sii : surveyItemInstances) {
            if(!sii.isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
