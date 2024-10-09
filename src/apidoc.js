  /**
   * @api {DELETE} /Surveys/:surveyName Delete Survey
   * @apiName DeleteSurvey
   * @apiGroup Surveys
   *
   *@apiParam {String} surveyName Name of Survey to Delete
   *
   *
   *@apiSuccessExample Success-Response:
   *     HTTP/1.1 204 No Content
   *
   *
   *@apiError (Error 4xx) {404} SurveyNotFound Survey Not Found
   *
   *@apiErrorExample Error-Response:
   *     HTTP/1.1 404 Not Found
   *     {
   *       "error": "Survey Not Found"
   *     }
   */

  /**
   * @api {GET} /Surveys/:surveyName Request Specific Survey
   * @apiName SpecificSurveys
   * @apiGroup Surveys
   *
   *@apiParam {String} surveyName Name of Survey to Request
   *
   *@apiSuccess {String} state Created, Completed, or Deleted
   *@apiSuccess {String} surveyName Name of the Survey
   *@apiSuccess {String[]} surveyItems List of Survey Items
   *
   *@apiSuccessExample Success-Response:
   *     HTTP/1.1 200 OK
   *    {
   *        "state": "created",
   *        "surveyName": "FirstSurvey",
   *        "surveyItems": [
   *            {
   *                "questionStem": "6 * 6 = ",
   *                "possibleAnswer": [
   *                   "36",
   *                   "33",
   *                   "42"
   *                ],
   *                "correctAnswer": "36",
   *                "surveyItemID": 1
   *            },
   *            {
   *                "questionStem": "testQ1 ",
   *                "possibleAnswer": [
   *                    "36",
   *                    "33",
   *                    "42"
   *                ],
   *                "correctAnswer": "idk",
   *                "surveyItemID": 4
   *            }
   *        ]
   *    }
   *
   *
       *@apiError (Error 4xx) {404} SurveyNotFound Survey Not Found
       *
       *@apiErrorExample Error-Response:
       *     HTTP/1.1 404 Not Found
       *     {
       *       "error": "Survey Not Found"
       *     }
   */

  /**
   * @api {GET} /Surveys Request All Surveys
   * @apiName AllSurveys
   * @apiGroup Surveys
   *
   *@apiSuccess {Object[]} List of all Surveys
   *@apiSuccess {String} state Created, Completed, or Deleted
   *@apiSuccess {String} surveyName Name of the Survey
   *@apiSuccess {String[]} surveyItems List of Survey Items
   *
   *@apiSuccessExample Success-Response:
   *     HTTP/1.1 200 OK
   *[
   *    {
   *        "state": "created",
   *        "surveyName": "FirstSurvey",
   *        "surveyItems": [
   *            {
   *                "questionStem": "6 * 6 = ",
   *                "possibleAnswer": [
   *                   "36",
   *                   "33",
   *                   "42"
   *                ],
   *                "correctAnswer": "36",
   *                "surveyItemID": 1
   *            },
   *            {
   *                "questionStem": "testQ1 ",
   *                "possibleAnswer": [
   *                    "36",
   *                    "33",
   *                    "42"
   *                ],
   *                "correctAnswer": "idk",
   *                "surveyItemID": 4
   *            }
   *        ]
   *    }
   *]
   *
   *@apiError (Error 4xx) {404} MalformedUrl Improper Url
   *
   *@apiErrorExample Error-Response:
   *     HTTP/1.1 404 Not Found
*   {
*       "timestamp": "2024-10-09T20:20:29.173+00:00",
*       "status": 404,
*        "error": "Not Found",
*       "message": "No message available",
*       "path": "/Survey"
*   }
   */

/**
*@api {PATCH} /Surveys/:surveyName Add Survey Item to Survey
*@apiName AddSurveyItemToSurvey
*@apiGroup Surveys
*
*@apiParam {String} surveyName Name of Survey to add Survey Item
*
*@apiSuccess {String} state Created, Completed, or Deleted
*@apiSuccess {String} surveyName Name of the Survey
*@apiSuccess {String[]} surveyItems List of Survey Items
*
*@apiBody {Integer} surveyItemId ID of the SurveyItem
*
*@apiSuccessExample Success-Response:
*     HTTP/1.1 200 OK
  *    {
  *        "state": "created",
  *        "surveyName": "FirstSurvey",
  *        "surveyItems": [
  *            {
  *                "questionStem": "6 * 6 = ",
  *                "possibleAnswer": [
  *                    "36",
  *                    "33",
  *                    "42"
  *                ],
  *                "correctAnswer": "36",
  *                "surveyItemID": 1
  *            }
  *        ]
  *    }
  *
  *
    *@apiError (Error 4xx) {404} SurveyItemNotFound Survey Item Not Found
    *
    *@apiErrorExample Error-Response:
    *     HTTP/1.1 404 Not Found
    *     {
    *       "error": "Survey Item Not Found"
    *     }
*/

/**
*@api {POST} /Surveys Create Survey
*@apiName CreateSurvey
*@apiGroup Surveys
*
*@apiSuccess {String} state Created, Completed, or Deleted
*@apiSuccess {String} surveyName Name of the Survey
*@apiSuccess {String[]} surveyItems Empty list to add survey items
*
*@apiBody {String} surveyName Name of the Survey
*
*@apiSuccessExample Success-Response:
*     HTTP/1.1 201 CREATED
*   {
*        "state": "created",
*        "surveyName": "SecondSurvey",
*        "surveyItems": []
*   }
*
*
  *@apiError (Error 4xx) {400} MissingFieldError Survey Request Incomplete, missing surveyName
  *
  *@apiErrorExample Error-Response:
  *     HTTP/1.1 400 Bad Request
  *     {
  *       "error": "Survey Request Incomplete, missing surveyName"
  *     }
*/

/**
*@api {POST} /SurveyItem Create Survey Item
*@apiName CreateSurveyItem
*@apiGroup SurveyItems
*
*@apiSuccess {String[]} possibleAnswer a list of possible answers for the surveyItem
*@apiSuccess {String} correctAnswer the correct answer for the surveyItem
*@apiSuccess {String} questionStem the question stem for th surveyItem
*@apiSuccess {Integer} surveyItemID the ID of the survey item
*
*@apiBody {String} questionStem the question stem for th surveyItem
*@apiBody {String[]} possibleAnswer a list of possible answers for the surveyItem
*@apiBody {String} correctAnswer the correct answer for the surveyItem
*
*@apiSuccessExample Success-Response:
*     HTTP/1.1 201 CREATED
*           {
*               "questionStem": "6 * 6 = ",
*               "possibleAnswer": [
*                   "36",
*                   "33",
*                   "42"
*               ],
*               "correctAnswer": "36"
*           }
*
  *@apiError (Error 4xx) {400} MissingFieldError Survey Item Request Incomplete, missing field
  *
  *@apiErrorExample Error-Response:
  *     HTTP/1.1 400 Bad Request
  *     {
  *       "error": "Survey Item Request Incomplete, missing field"
  *     }
*/

 /**
  * @api {GET} /SurveyInstances/:state Request All Survey Instances of State
  * @apiName AllSurveyInstancesOfState
  * @apiGroup SurveyInstances
  *
  *@apiParam {String} state State of Survey Instance
  *
  *@apiSuccess {String} state Created, InProgress, Completed
  *@apiSuccess {String} surveyInstanceName Name of Survey that was instantiated
  *@apiSuccess {Object[]} surveyItemInstances List of Survey Item Instances in the Survey Instance
  *
  *@apiSuccessExample Success-Response:
  *     HTTP/1.1 200 OK
  *   [
  *    {
  *        "state": "created",
  *        "surveyInstanceName": "FirstSurvey",
  *        "surveyItemInstances": [
  *            {
  *                "questionStem": "6 * 6 = ",
  *                "possibleAnswer": [
  *                    "36",
  *                    "33",
  *                    "42"
  *                ],
  *                "correctAnswer": "36",
  *                "answerChoice": null,
  *                "answerEval": null,
  *                "completed": false,
  *                "surveyItemID": 1
  *            }
  *        ],
  *        "user": "Nick"
  *    }
  *   ]
  *
  *@apiError (Error 4xx) {404} noSurveyInstances No survey instances found
  *
  *@apiErrorExample Error-Response:
  *     HTTP/1.1 404 Not Found
  *     {
  *       "error": "NoSurveyInstancesFound"
  *     }
  */

  /**
   * @api {GET} /SurveyInstances Request All Survey Instances
   * @apiName AllSurveyInstances
   * @apiGroup SurveyInstances
   *
   *@apiSuccess {String} state Created, InProgress, Completed
   *@apiSuccess {String} surveyInstanceName Name of Survey that was instantiated
   *@apiSuccess {Object[]} surveyItemInstances List of Survey Item Instances in the Survey Instance
   *
   *@apiSuccessExample Success-Response:
   *     HTTP/1.1 200 OK
  *   [
  *    {
  *        "state": "created",
  *        "surveyInstanceName": "FirstSurvey",
  *        "surveyItemInstances": [
  *            {
  *                "questionStem": "6 * 6 = ",
  *                "possibleAnswer": [
  *                    "36",
  *                    "33",
  *                    "42"
  *                ],
  *                "correctAnswer": "36",
  *                "answerChoice": null,
  *                "answerEval": null,
  *                "completed": false,
  *                "surveyItemID": 1
  *            }
  *        ],
  *        "user": "Nick"
  *    }
  *   ]
   *
   *@apiError (Error 4xx) {404} noSurveyInstances No survey instances found
   *
   *@apiErrorExample Error-Response:
   *     HTTP/1.1 404 Not Found
   *     {
   *       "error": "NoSurveyInstancesFound"
   *     }
   */

/**
  * @api {POST} /SurveyInstances Create Survey Instance
  * @apiName CreateSurveyInstance
  * @apiGroup SurveyInstances
  *
  *@apiSuccess {String} state Created, InProgress, Completed
  *@apiSuccess {String} surveyInstanceName Name of Survey that was instantiated
  *@apiSuccess {Object[]} surveyItemInstances List of Survey Item Instances in the Survey Instance
  *
  *
  *@apiBody {String} user Name of the User
  *@apiBody {String} surveyName Name of the Survey
  *
  *@apiSuccessExample Success-Response:
  *     HTTP/1.1 201 CREATED
  *    {
  *        "state": "created",
  *        "surveyInstanceName": "FirstSurvey",
  *        "surveyItemInstances": [
  *            {
  *                "questionStem": "6 * 6 = ",
  *                "possibleAnswer": [
  *                    "36",
  *                    "33",
  *                    "42"
  *                ],
  *                "correctAnswer": "36",
  *                "answerChoice": null,
  *                "answerEval": null,
  *                "completed": false,
  *                "surveyItemID": 1
  *            }
  *        ],
  *        "user": "Nick"
  *    }
  *
  *@apiError (Error 5xx) {500} SurveyInstanceAlreadyExists SurveyInstance already exists
  *
  *@apiErrorExample Error-Response:
  *     HTTP/1.1 500 Internal Server Error
  *     {
  *       "error": "SurveyInstance already exists"
  *     }
  */

/**
  *@api {PATCH} /SurveyInstances/:surveyInstanceName/:surveyItemInstanceID Answer SurveyInstanceItem on Survey Instance
  *@apiName AnswerSurveyInstanceItemOnSurveyInstance
  *@apiGroup SurveyInstances
  *
  *@apiParam {String} surveyInstanceName Name of Survey Instance
  *@apiParam {String} surveyItemInstanceID ID of Survey Item Instance
  *
  *@apiSuccess {String} state Completed
  *@apiSuccess {String} surveyInstanceName Name of Survey that was answered
  *@apiSuccess {Object[]} surveyItemInstances List of Survey Item Instances in the Survey Instance
  *
  *
  *@apiBody {String} answerChoice Answer chosen
  *
  *@apiSuccessExample Success-Response:
  *     HTTP/1.1 200 OK
  *{
  *  "state": "Completed",
  *  "surveyInstanceName": "FirstSurvey",
  *  "surveyItemInstances": [
  *      {
  *          "questionStem": "6 * 6 = ",
  *          "possibleAnswer": [
  *              "36",
  *              "33",
  *              "42"
  *          ],
  *          "correctAnswer": "36",
  *          "answerChoice": "36",
  *          "answerEval": "correct",
  *          "completed": true,
  *          "surveyItemID": 1
  *      }
  *  ],
  *  "user": "Nick"
  *}
  *
  *@apiError (Error 4xx) {404} SurveyInstanceAlreadyExists SurveyInstance already exists
  *
  *@apiErrorExample Error-Response:
  *     HTTP/1.1 404 Not Found
  *     {
  *       "error": "Survey Not Found"
  *     }
  */