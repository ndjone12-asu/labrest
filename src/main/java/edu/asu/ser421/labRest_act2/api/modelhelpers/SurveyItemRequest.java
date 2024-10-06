package edu.asu.ser421.labRest_act2.api.modelhelpers;

import java.util.ArrayList;
import java.util.List;

public class SurveyItemRequest {
    public SurveyItemRequest(){}
    public SurveyItemRequest(int id, String questionStem, ArrayList<String> possibleAnswer, String correctAnswer) {
        __id = id;
        __questionStem = questionStem;
        __possibleAnswer = possibleAnswer;
        __correctAnswer = correctAnswer;
    }
    private int __id;
    private String __questionStem;
    private ArrayList<String> __possibleAnswer;
    private String __correctAnswer;

    public int getID() {
        return __id;
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

    public void setID(int id) {
        __id = id;
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
