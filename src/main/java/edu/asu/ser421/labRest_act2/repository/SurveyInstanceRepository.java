package edu.asu.ser421.labRest_act2.repository;

import edu.asu.ser421.labRest_act2.model.SurveyInstance;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SurveyInstanceRepository {
    private static ArrayList<SurveyInstance> surveyInstances = new ArrayList<>();
    public List<SurveyInstance> getSurveyInstances() {
        return surveyInstances;
    }
}
