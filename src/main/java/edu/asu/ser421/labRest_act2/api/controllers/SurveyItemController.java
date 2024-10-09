package edu.asu.ser421.labRest_act2.api.controllers;

import edu.asu.ser421.labRest_act2.api.modelhelpers.SurveyItemRequest;
import edu.asu.ser421.labRest_act2.api.modelhelpers.SurveyItemResponse;
import edu.asu.ser421.labRest_act2.model.exceptions.SurveyDeletedException;
import edu.asu.ser421.labRest_act2.model.exceptions.SurveyItemRequestIncomplete;
import edu.asu.ser421.labRest_act2.services.SurveyAPIService;
import edu.asu.ser421.labRest_act2.services.SurveyAPIServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/SurveyItems")
@RestController
public class SurveyItemController {
@Autowired
private SurveyAPIService surveyAPIService;
    @GetMapping
    public ResponseEntity<List<SurveyItemResponse>> returnSurveyItems() {
        return new ResponseEntity<List<SurveyItemResponse>>(SurveyItemResponse.convertSurveyItemsToResponses(surveyAPIService.getSurveyItems()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SurveyItemResponse> createSurveyItem(@RequestBody SurveyItemRequest surveyItemRequest) throws Exception {
        return new ResponseEntity<>(new SurveyItemResponse(surveyAPIService.createSurveyItem(surveyItemRequest.getQuestionStem(), surveyItemRequest.getPossibleAnswer(), surveyItemRequest.getCorrectAnswer())), HttpStatus.CREATED);
    }

    @ExceptionHandler(value = SurveyItemRequestIncomplete.class)
    public ResponseEntity<?> handleThrowable(SurveyItemRequestIncomplete e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.BAD_REQUEST);
    }
}
