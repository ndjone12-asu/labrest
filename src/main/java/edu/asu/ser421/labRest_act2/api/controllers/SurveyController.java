package edu.asu.ser421.labRest_act2.api.controllers;

import edu.asu.ser421.labRest_act2.api.modelhelpers.SurveyItemRequest;
import edu.asu.ser421.labRest_act2.api.modelhelpers.SurveyRequest;
import edu.asu.ser421.labRest_act2.api.modelhelpers.SurveyResponse;
import edu.asu.ser421.labRest_act2.model.exceptions.*;
import edu.asu.ser421.labRest_act2.services.SurveyAPIService;
import edu.asu.ser421.labRest_act2.services.SurveyAPIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Surveys")
@RestController
public class SurveyController {
    @Autowired
    private SurveyAPIService surveyAPIService;

    @GetMapping
    public ResponseEntity<List<SurveyResponse>> returnSurveys() {
        return new ResponseEntity<>(SurveyResponse.convertSurveysToResponses(surveyAPIService.getSurveys()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SurveyResponse> createSurvey(@RequestBody SurveyRequest surveyRequest) throws Exception {
        return new ResponseEntity<>(new SurveyResponse(surveyAPIService.createSurvey(surveyRequest.getSurveyName())), HttpStatus.CREATED);
    }

    @GetMapping("/{surveyName}")
    public ResponseEntity<SurveyResponse> returnSurvey(@PathVariable String surveyName) {
        return new ResponseEntity<>(new SurveyResponse(surveyAPIService.getSurvey(surveyName)), HttpStatus.OK);
    }

    @PatchMapping("/{surveyName}")
    public ResponseEntity<SurveyResponse> addSurveyItem(@PathVariable String surveyName, @RequestBody SurveyItemRequest surveyItemId) {
        return new ResponseEntity<>(new SurveyResponse(surveyAPIService.addSurveyItem(surveyName, surveyItemId.getSurveyItemId())), HttpStatus.OK);
    }

    @DeleteMapping("/{surveyName}")
    public ResponseEntity<SurveyResponse> deleteSurvey(@PathVariable String surveyName) {
        return new ResponseEntity<>(new SurveyResponse(surveyAPIService.deleteSurvey(surveyName)), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = SurveyNotFoundException.class)
    public ResponseEntity<?> handleThrowable(SurveyNotFoundException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = SurveyItemNotFoundException.class)
    public ResponseEntity<?> handleThrowable(SurveyItemNotFoundException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = SurveyFullException.class)
    public ResponseEntity<?> handleThrowable(SurveyFullException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SurveyDeletedException.class)
    public ResponseEntity<?> handleThrowable(SurveyDeletedException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = SurveyInternalException.class)
    public ResponseEntity<?> handleThrowable(SurveyInternalException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = SurveyItemRequestIncomplete.class)
    public ResponseEntity<?> handleThrowable(SurveyItemRequestIncomplete e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.BAD_REQUEST);
    }

}
