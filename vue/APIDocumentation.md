# Contest Application API

## Overview

Brief description of the API and its purpose.
This API is for [INSERT NAME], a contest management application. Its purpose to 

## Base URL

Base URL: http://localhost:9000

## Authentication

Describe the authentication method required to access the API (e.g., API key, OAuth).

## Errors

Document common error responses and their meanings.

## Rate Limits

Specify any rate limiting policies if applicable.

## Endpoints

### Fetch List of Contests

### Description
This endpoint retrieves a list of all contests.

### Authorization
This endpoint is accessible to all users ('permitAll').

### Endpoint
#### `GET /contests`

##### Parameters
N/A

#### Request
No request parameters are required for this endpoint.

### Response
The response is a JSON array containing a list of contests.

#### Example Response
```json
[
    {
        "contestId": 1,
        "contestName": "Example Contest 1",
        "contestDescription": "Example Description",
        "dateAndTime": "2024-01-01",
        "contestLocation": "Location, EX"
    },
    {
        "contestId": 2,
        "contestName": "Example Contest 2",
        "contestDescription": "Example Description",
        "dateAndTime": "2024-01-01",
        "contestLocation": "Location, EX"
    }
]
```
### Fetch Contest by ID

### Description
This endpoint retrieves a contest of with a given id.

### Authorization
This endpoint is accessible to all users ('permitAll').

### Endpoint
#### `GET /contests/{id}`

##### Parameters
`{id}` (required): The id of the contest.

#### Request
No additional request parameters are required for this endpoint.

### Response
The response is a JSON object containing details about the contest.
#### Example Response
```json
[
    {
        "contestId": 1,
        "contestName": "Example Contest 1",
        "contestDescription": "Example Description",
        "dateAndTime": "2024-01-01",
        "contestLocation": "Location, EX"
    }
]
```