package edu.asu.ser421.labRest_act2.api.modelhelpers;

public class SurveyItemInstanceRequest {
    public SurveyItemInstanceRequest(){}
    public SurveyItemInstanceRequest(int id, String answerChoice){
        __id = id;
        __answerChoice = answerChoice;
    }
    private int __id;
    private String __answerChoice;
    public int getID() {
        return __id;
    }
    public String getAnswerChoice() {
        return __answerChoice;
    }
    public void setID(int id) {
        __id = id;
    }
    public void setAnswerChoice(String answerChoice) {
        __answerChoice = answerChoice;
    }
}
