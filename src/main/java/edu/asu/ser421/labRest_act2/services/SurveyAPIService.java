package edu.asu.ser421.labRest_act2.services;

import edu.asu.ser421.labRest_act2.model.Survey;
import edu.asu.ser421.labRest_act2.model.SurveyInstance;
import edu.asu.ser421.labRest_act2.model.SurveyItem;
import edu.asu.ser421.labRest_act2.model.exceptions.SurveyNotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface SurveyAPIService {
    List<SurveyItem> getSurveyItems();
    List<Survey> getSurveys();
    List<SurveyInstance> getSurveyInstances();

    void generateSurveyItems();

    void generateSurveys();
    SurveyItem createSurveyItem();

    SurveyItem createSurveyItem(String questionStem, ArrayList<String> possibleAnswers, String correctAnswer) throws Exception;
    Survey createSurvey();

    Survey createSurvey(String surveyName) throws Exception;

    SurveyInstance createSurveyInstance(String user, String surveyName) throws Exception;

    Survey addSurveyItem(String surveyName, int surveyItemId);

    SurveyInstance answerSurveyInstanceItem(String surveyInstanceName, String surveyItemInstanceId, String answerChoice);

    Survey getSurvey(String name) throws SurveyNotFoundException;

    List<SurveyInstance> getSurveyInstancesOfState(String state);
    Survey deleteSurvey(String surveyName);
}
