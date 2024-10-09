package edu.asu.ser421.labRest_act2.api.controllers;
import edu.asu.ser421.labRest_act2.api.modelhelpers.*;
import edu.asu.ser421.labRest_act2.model.exceptions.*;
import edu.asu.ser421.labRest_act2.services.SurveyAPIService;
import edu.asu.ser421.labRest_act2.services.SurveyAPIServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/SurveyInstances")
@RestController
public class SurveyInstanceController {

@Autowired
private SurveyAPIService surveyAPIService;


    @GetMapping
    public ResponseEntity<List<SurveyInstanceResponse>> returnSurveyInstances() {
       return new ResponseEntity<List<SurveyInstanceResponse>> (SurveyInstanceResponse.convertSurveyInstancesToResponses(surveyAPIService.getSurveyInstances()), HttpStatus.OK);

    }


    @GetMapping("/states/{state}")
    public ResponseEntity<List<SurveyInstanceResponse>> returnSurveyInstancesOfState(@PathVariable String state) {
        return new ResponseEntity<List<SurveyInstanceResponse>> (SurveyInstanceResponse.convertSurveyInstancesToResponses(surveyAPIService.getSurveyInstancesOfState(state)), HttpStatus.OK);

    }
    @GetMapping("/{surveyInstanceName}")
    public ResponseEntity<SurveyInstanceResponse> returnSurveyInstancesByName(@PathVariable String surveyInstanceName) {
        return new ResponseEntity<> (new SurveyInstanceResponse(surveyAPIService.getSurveyInstancesByName(surveyInstanceName)), HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<List<SurveyInstanceResponse>> returnSurveyInstancesOfStateNoneGiven() {
        return new ResponseEntity<List<SurveyInstanceResponse>> (SurveyInstanceResponse.convertSurveyInstancesToResponses(surveyAPIService.getSurveyInstancesOfState(null)), HttpStatus.OK);

    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SurveyInstanceResponse> createSurveyInstance(@RequestBody SurveyInstanceRequest surveyInstanceRequest) throws Exception {
        return new ResponseEntity<>(new SurveyInstanceResponse(surveyAPIService.createSurveyInstance(surveyInstanceRequest.getUser(), surveyInstanceRequest.getSurveyName())), HttpStatus.CREATED);
    }

    @PatchMapping("/{surveyInstanceName}/{surveyItemInstanceId}")
    public ResponseEntity<SurveyInstanceResponse> answerSurveyInstanceItem(@PathVariable String surveyInstanceName, @PathVariable String surveyItemInstanceId, @RequestBody SurveyItemInstanceRequest surveyItemInstanceRequest) {
        return new ResponseEntity<>(new SurveyInstanceResponse(surveyAPIService.answerSurveyInstanceItem(surveyInstanceName, surveyItemInstanceId, surveyItemInstanceRequest.getAnswerChoice())), HttpStatus.OK);
    }
    @ExceptionHandler(value = SurveyInternalException.class)
    public ResponseEntity<?> handleThrowable(SurveyInternalException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = SurveyDeletedException.class)
    public ResponseEntity<?> handleThrowable(SurveyDeletedException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = SurveyNotFoundException.class)
    public ResponseEntity<?> handleThrowable(SurveyNotFoundException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = SurveyInstanceNotFoundException.class)
    public ResponseEntity<?> handleThrowable(SurveyInstanceNotFoundException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = SurveyItemNotFoundException.class)
    public ResponseEntity<?> handleThrowable(SurveyItemNotFoundException e) {
        return new ResponseEntity<>(e.getMessageJSON(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> handleThrowable(RuntimeException e) {
        JSONObject error = new JSONObject();
        error.put("error", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

