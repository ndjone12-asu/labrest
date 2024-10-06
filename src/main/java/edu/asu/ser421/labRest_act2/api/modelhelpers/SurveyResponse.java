package edu.asu.ser421.labRest_act2.api.modelhelpers;

import edu.asu.ser421.labRest_act2.model.Survey;
import edu.asu.ser421.labRest_act2.model.SurveyItem;

import java.util.ArrayList;
import java.util.List;

public class SurveyResponse {

    private Survey __survey;
    public SurveyResponse(){super();}
    public SurveyResponse(Survey survey) {
        __survey = survey;
    }
    public String getSurveyName() {
        return __survey.getSurveyName();
    }
    public String getState() {
        return __survey.getState();
    }
    public ArrayList<SurveyItem> getSurveyItems() {
        return __survey.getSurveyItems();
    }
    public static List<SurveyResponse> convertSurveysToResponses(List<Survey> surveys) {
        List<SurveyResponse> surveyResponses = new ArrayList<>();

        if(surveyResponses != null) {
            for(Survey s : surveys) {
                surveyResponses.add(new SurveyResponse(s));
            }
        }
        return surveyResponses;
    }
}
