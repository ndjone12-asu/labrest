package edu.asu.ser421.labRest_act2.api.modelhelpers;

import edu.asu.ser421.labRest_act2.model.SurveyItem;

import java.util.ArrayList;
import java.util.List;

public class SurveyItemResponse {
    private String __url;
    private SurveyItem __surveyItem;
    public SurveyItemResponse(){super();}
    public SurveyItemResponse(SurveyItem surveyItem) {
        __surveyItem = surveyItem;
    }
    public String getQuestionStem() {
        return __surveyItem.getQuestionStem();
    }
    public int getSurveyItemID() {
        return __surveyItem.getSurveyItemID();
    }
    public ArrayList<String> getPossibleAnswer(){
        return __surveyItem.getPossibleAnswer();
    }
    public String getCorrectAnswer() {
        return __surveyItem.getCorrectAnswer();
    }
    public static List<SurveyItemResponse> convertSurveyItemsToResponses(List<SurveyItem> surveyItems) {
        List<SurveyItemResponse> surveyItemResponses = new ArrayList<>();

        if(surveyItems != null) {
            for(SurveyItem s : surveyItems) {
                surveyItemResponses.add(new SurveyItemResponse(s));
            }
        }
        return surveyItemResponses;
    }
}
