package edu.asu.ser421.labRest_act2.api.modelhelpers;

import java.util.ArrayList;
import java.util.List;

public class SurveyItemRequest {
    public SurveyItemRequest(){}
    public SurveyItemRequest(int surveyItemId, String questionStem, ArrayList<String> possibleAnswer, String correctAnswer) {
        __surveyItemId = surveyItemId;
        __questionStem = questionStem;
        __possibleAnswer = possibleAnswer;
        __correctAnswer = correctAnswer;
    }
    private int __surveyItemId;
    private String __questionStem;
    private ArrayList<String> __possibleAnswer;
    private String __correctAnswer;

    public int getSurveyItemId() {
        System.out.println("THis ID: " + __surveyItemId);
        return __surveyItemId;
    }
    public String getQuestionStem(){
        return __questionStem;
    }

    public ArrayList<String> getPossibleAnswer(){
        return __possibleAnswer;
    }

    public String getCorrectAnswer() {
        return __correctAnswer;
    }

    public void setSurveyItemId(int surveyItemId) {
        __surveyItemId = surveyItemId;
    }
    public void setQuestionStem(String questionStem) {
        __questionStem = questionStem;
    }

    public void setPossibleAnswer(ArrayList<String> possibleAnswer) {
        __possibleAnswer = possibleAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        __correctAnswer = correctAnswer;
    }
}
