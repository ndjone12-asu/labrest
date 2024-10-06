package edu.asu.ser421.labRest_act2.api.modelhelpers;

import edu.asu.ser421.labRest_act2.model.Survey;
import edu.asu.ser421.labRest_act2.model.SurveyInstance;
import edu.asu.ser421.labRest_act2.model.SurveyItemInstance;

import java.util.ArrayList;
import java.util.List;

public class SurveyInstanceResponse {
    private SurveyInstance __surveyInstance;
    public SurveyInstanceResponse(){super();}
    public SurveyInstanceResponse(SurveyInstance surveyInstance) {
        __surveyInstance = surveyInstance;
    }
    public String getSurveyInstanceName() {
        return __surveyInstance.getSurveyInstanceName();
    }
    public String getUser() {
        return __surveyInstance.getUser();
    }
    public String getState() {
        return __surveyInstance.getState();
    }

    public ArrayList<SurveyItemInstance> getSurveyItemInstances(){
        return __surveyInstance.getSurveyItemInstances();
    }
    public void setSurveyInstanceName(String name) {
        __surveyInstance.setSurveyInstanceName(name);
    }
    public void setUser(String user) {
        __surveyInstance.setUser(user);
    }

    public void setState(String state) {
        __surveyInstance.setState(state);
    }
    public static List<SurveyInstanceResponse> convertSurveyInstancesToResponses(List<SurveyInstance> surveyInstances) {
        List<SurveyInstanceResponse> surveyInstanceResponse = new ArrayList<>();
        if(surveyInstances != null) {
            for(SurveyInstance si : surveyInstances) {
                surveyInstanceResponse.add(new SurveyInstanceResponse(si));
            }
        }
        return surveyInstanceResponse;
    }
}
