package edu.asu.ser421.labRest_act2.model;

import edu.asu.ser421.labRest_act2.api.modelhelpers.SurveyItemRequest;

import java.util.ArrayList;

public class SurveyItem {
    final int id;
    final String questionStem;
    final ArrayList<String> possibleAnswer;
    final String correctAnswer;

    public SurveyItem(int id, SurveyItemRequest sir) {
        this(id, sir.getQuestionStem(), sir.getPossibleAnswer(), sir.getCorrectAnswer());
    }
    public SurveyItem(int id, String questionStem, ArrayList<String> possibleAnswer, String correctAnswer) {
        this.id = id;
        this.questionStem = questionStem;
        this.possibleAnswer = possibleAnswer;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionStem(){
        return this.questionStem;
    }
    public ArrayList<String> getPossibleAnswer(){
        return this.possibleAnswer;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public int getSurveyItemID() {
        return this.id;
    }
}
