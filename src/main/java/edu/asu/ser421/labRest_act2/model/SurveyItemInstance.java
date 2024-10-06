package edu.asu.ser421.labRest_act2.model;

import java.util.ArrayList;
import java.util.Objects;

public class SurveyItemInstance extends SurveyItem{
    private String answerChoice;
    private String answerEval;
    private boolean completed;
    SurveyItemInstance(SurveyItem surveyItem) {
        super(surveyItem.id, surveyItem.questionStem, surveyItem.possibleAnswer, surveyItem.correctAnswer);
        this.answerChoice = null;
        this.answerEval = null;
        this.completed = false;
    }

    public String getQuestionStem() {
        return this.questionStem;
    }

    public ArrayList<String> getPossibleAnswer() {
        return this.possibleAnswer;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }
    public String getAnswerChoice() {
         return this.answerChoice;
    }

    public String getAnswerEval() {
        return answerEval;
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setAnswerChoice(String choice) {
        if(!isCompleted()) {
            this.answerChoice = choice;
        }
    }

    public void setAnswerEval() {
        if(Objects.equals(this.answerChoice, this.getCorrectAnswer())) {
            this.answerEval = "correct";
        } else {
            this.answerEval = "incorrect";
        }
    }

    public void setCompleted() {
        this.completed = answerEval != null;
    }
}
