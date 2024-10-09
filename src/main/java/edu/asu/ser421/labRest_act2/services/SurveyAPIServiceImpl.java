package edu.asu.ser421.labRest_act2.services;

import edu.asu.ser421.labRest_act2.model.Survey;
import edu.asu.ser421.labRest_act2.model.SurveyInstance;
import edu.asu.ser421.labRest_act2.model.SurveyItem;
import edu.asu.ser421.labRest_act2.model.SurveyItemInstance;
import edu.asu.ser421.labRest_act2.model.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class SurveyAPIServiceImpl implements SurveyAPIService {

    private ArrayList<SurveyItem> surveyItems = new ArrayList<>();
    private ArrayList<Survey> surveys = new ArrayList<>();
    private ArrayList<SurveyInstance> surveyInstances = new ArrayList<>();
    public SurveyAPIServiceImpl() {
        generateSurveyItems();
        generateSurveys();

    }
    @Override
    public List<SurveyItem> getSurveyItems() {
        return new ArrayList<>(surveyItems);
    }

    @Override
    public List<Survey> getSurveys() {
        return new ArrayList<>(surveys);
    }

    @Override
    public List<SurveyInstance> getSurveyInstances() {
        return new ArrayList<>(surveyInstances);
    }

    @Override
    public void generateSurveyItems() {
        ArrayList<String> answerOptions = new ArrayList<>();
        answerOptions.add("36");
        answerOptions.add("33");
        answerOptions.add("42");
        surveyItems.add(new SurveyItem(1, "6 * 6 = ", answerOptions, "36"));
        surveyItems.add(new SurveyItem(2, "23 + 10 = ", answerOptions, "33"));
        surveyItems.add(new SurveyItem(3, "The answer to everything is ", answerOptions, "42"));
        surveyItems.add(new SurveyItem(4, "testQ1 ", answerOptions, "idk"));
        surveyItems.add(new SurveyItem(5, "testQ2 ", answerOptions, "red"));

    }

    @Override
    public void generateSurveys() {
        surveys.add(new Survey("FirstSurvey"));
        surveys.get(0).addSurveyItem(surveyItems.get(0));
        surveys.add(new Survey("TestMarkedForDelete"));
        surveys.get(1).addSurveyItem(surveyItems.get(0));
        surveys.get(1).addSurveyItem(surveyItems.get(1));
        surveys.get(1).addSurveyItem(surveyItems.get(2));
        surveys.get(1).setState("deleted");
        surveys.add(new Survey("TestExceedItemLimit"));
        surveys.get(2).addSurveyItem(surveyItems.get(0));
        surveys.get(2).addSurveyItem(surveyItems.get(1));
        surveys.get(2).addSurveyItem(surveyItems.get(2));
        surveys.get(2).addSurveyItem(surveyItems.get(3));
        surveys.get(2).addSurveyItem(surveyItems.get(4));
        this.createSurveyInstance("TestUser", "FirstSurvey");

    }

    @Override
    public SurveyItem createSurveyItem() {
        return null;
    }

    @Override
    public SurveyItem createSurveyItem(String questionStem, ArrayList<String> possibleAnswers, String correctAnswer) throws Exception {
        int id = surveyItems.size() + 1;
        if(questionStem == null || possibleAnswers == null || correctAnswer == null) {
            throw new SurveyItemRequestIncomplete("Survey Item Request Incomplete, missing field");
        }
        SurveyItem rval = new SurveyItem(id, questionStem, possibleAnswers, correctAnswer);
        try {
            if (this.surveyItems.add(rval)) {
                return rval;
            } else {
                throw new Exception("Internal Service Error, unable to create surveyItem");
            }
        } catch (Throwable t) {
            throw new Exception();
        }
    }

    @Override
    public Survey createSurvey() {
        throw new SurveyItemRequestIncomplete("Survey Request Incomplete, missing surveyName");
    }

    @Override
    public Survey createSurvey(String surveyName) throws Exception {
        if(surveyName == null) {
            throw new SurveyItemRequestIncomplete("Survey Request Incomplete, missing surveyName");
        }
        Survey rval = new Survey(surveyName);
        try {
            if(this.surveys.add(rval)) {

                return rval;
            } else {
                throw new Exception("Internal Service Error, unable to create surveyItem");
            }
        } catch (Throwable t) {
            throw new Exception();
        }
    }

    @Override
    public SurveyInstance createSurveyInstance(String user, String surveyName){
        Survey surveyToInstantiate = null;
        int i = 0;

        for(Survey s : this.surveys) {
            if(s.getSurveyName().equals(surveyName)) {
                if(s.getState().equals("deleted")) {
                    throw new SurveyDeletedException("Survey Marked for Deletion");
                }
                surveyToInstantiate = s;
                break;
            }
        }
        if(surveyToInstantiate == null) {
            throw new SurveyNotFoundException("Survey Not Found");
        }

        SurveyInstance rval = new SurveyInstance(surveyName, user, surveyToInstantiate);
        rval.setState("Created");
        System.out.println(rval.getState());
        for(SurveyInstance si : surveyInstances) {
            if(si.getSurveyInstanceName().equals(surveyName)) {
                throw new SurveyInternalException("SurveyInstance already exists");
            }
        }
        if (surveyInstances.add(rval)) {
            return rval;
        } else {
            throw new SurveyInternalException("Internal Service Error, unable to create survey instance");
        }

    }

    @Override
    public Survey addSurveyItem(String surveyName, int surveyItemId) {
        SurveyItem surveyItemToAdd = null;
        Survey patchSurvey = null;
        int i = 0;
        for(SurveyItem si : surveyItems) {
            if(si.getSurveyItemID() == surveyItemId) {
                surveyItemToAdd = si;
                System.out.println(surveyItemToAdd.getSurveyItemID());
                break;
            }
        }
        if(surveyItemToAdd == null) {
            throw new SurveyItemNotFoundException("Survey Item Not Found");
        }
        for (Survey s : surveys) {
            if (s.getSurveyName().equals(surveyName)) {
                if(s.getState().equals("deleted")){
                    throw new SurveyDeletedException("Survey Marked for deletion");
                }
                if (s.getSurveyItems().size() < 5) {
                    s.addSurveyItem(surveyItemToAdd);
                    patchSurvey = s;
                    break;
                } else {
                    throw new SurveyFullException("Survey Item Limit Reached, cannot add new surveys");
                }
            }
        }
        return patchSurvey;
    }

    @Override
    public SurveyInstance answerSurveyInstanceItem(String surveyInstanceName, String surveyItemInstanceId, String answerChoice) {
        SurveyInstance surveyInstanceToAnswer = null;
        SurveyItemInstance surveyItemInstanceToAnswer = null;
        for(SurveyInstance si : surveyInstances){
            if(si.getSurveyInstanceName().equals(surveyInstanceName)){
                surveyInstanceToAnswer = surveyInstances.get(surveyInstances.indexOf(si));
                break;
            }
        }
        if(surveyInstanceToAnswer == null) {
            throw new SurveyInstanceNotFoundException("Survey Instance Does Not Exist");
        }
        for(SurveyItemInstance sii : surveyInstanceToAnswer.getSurveyItemInstances()) {
            if(sii.getSurveyItemID() == Integer.parseInt(surveyItemInstanceId)) {
                surveyItemInstanceToAnswer = surveyInstanceToAnswer.getSurveyItemInstances().get(surveyInstanceToAnswer.getSurveyItemInstances().indexOf(sii));
                break;
            }
        }
        if(surveyItemInstanceToAnswer == null) {
            throw new SurveyItemNotFoundException("Survey Item Instance Does Not Exist");
        }


        surveyItemInstanceToAnswer.setAnswerChoice(answerChoice);
        surveyItemInstanceToAnswer.setAnswerEval();
        surveyItemInstanceToAnswer.setCompleted();

        if(surveyInstanceToAnswer.isCompleted()) {
            surveyInstanceToAnswer.setState("Completed");
        } else {
            surveyInstanceToAnswer.setState("InProgress");
        }

        return surveyInstanceToAnswer;
    }

    @Override
    public Survey getSurvey(String name){
        for(Survey s : surveys) {
            if (s.getSurveyName().equals(name)) return s;
        }
            throw new SurveyNotFoundException("Survey Not Found");
        }
    @Override
    public List<SurveyInstance> getSurveyInstancesOfState(String state) {
        ArrayList<String> states = new ArrayList<>(Arrays.asList("Created", "InProgress", "Completed"));
        if(!states.contains(state) && state != null) {
            throw new RuntimeException("Not A Valid State");
        }
        ArrayList<SurveyInstance> surveyInstancesOfState = new ArrayList<>();
        for(SurveyInstance si : surveyInstances) {
            if(si.getState().equals(state)) {
                surveyInstancesOfState.add(si);
            } else if (state == null) {
                surveyInstancesOfState.add(si);
            }
        }
        return surveyInstancesOfState;
    }

    @Override
    public SurveyInstance getSurveyInstancesByName(String name) {
        for(SurveyInstance si : surveyInstances) {
            if (si.getSurveyName().equals(name)) return si;
        }
        throw new SurveyNotFoundException("Survey Not Found");
    }

    @Override
    public Survey deleteSurvey(String surveyName) {
        Survey surveyToDelete = null;
        for(Survey s : surveys) {
            if(s.getSurveyName().equals(surveyName)) {
                s.setState("deleted");
                surveyToDelete = s;
                break;
            }
        }
        if(surveyToDelete == null) {
            throw new SurveyNotFoundException("Survey Not Found");
        }
        return surveyToDelete;
    }
}
