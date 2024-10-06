package edu.asu.ser421.labRest_act2.repository;

import edu.asu.ser421.labRest_act2.model.SurveyItem;

import java.util.ArrayList;

public class SurveyItemRepository {
    private static ArrayList<SurveyItem> surveyItems = new ArrayList<>();
    private static ArrayList<String> answerOptions = new ArrayList<>();
    static {
        answerOptions.add("36");
        answerOptions.add("33");
        answerOptions.add("42");

        surveyItems.add(new SurveyItem(1, "6 * 6 = ", answerOptions, "36"));
        surveyItems.add(new SurveyItem(2, "23 + 10 = ", answerOptions, "33"));
        surveyItems.add(new SurveyItem(3, "The answer to everything is ", answerOptions, "42"));
    }
}
