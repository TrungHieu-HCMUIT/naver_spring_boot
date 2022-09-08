# SpringBoot project of Naver's course

# Response structure

1. [Success response](#success-response)
2. [Error response](#error-response)

# Validation
1. [Data constraint](#data-constraint)

# APIs
1. [Employee](#employee)
2. [Department](#department)
3. [Error example](#error-example)

## Success response

| Field  | Description                                  |
|--------|:---------------------------------------------|
| data   | The response model that clients need         |
| status | The status code of the response, usually 200 |

## Error response

| Field   | Description                                                                           |
|---------|:--------------------------------------------------------------------------------------|
| message | The message describes the error                                                       |
| errKey  | The error key that can be used to configure multi-language on the client application  |
| status  | The status code of the response                                                       |

## Data constraint 
1. employeeId, departmentId: *Must be larger than 0 and not null*
2. name, deptName: *Has length >=10 and <=50, not null*
3. birthdate: *should be formatted to dd-MM-yyyy*
4. gender: *Must be either MALE, FEMALE or OTHER*
5. email: *Must be a valid gmail*
6. description: *Must not be empty*

## Employee

Get Employee DTO from request

**`GET /employee`**
```
{
    "data": {
        "employeeId": 0,
        "name": "Trung Hieu",
        "birthDate": "01/07/2001",
        "gender": "MALE",
        "email": "trunghieu0107@gmail.com"
    },
    "statusCode": 200
}
```

## Department

Get Department DTO from request

**`GET /department`**
```
{
    "data": {
        "departmentId": 0,
        "name": "IT department",
        "description": "description",
        "employees": [
            {
                "employeeId": 0,
                "name": "Trung Hieu",
                "birthDate": "01/07/2001",
                "gender": "MALE",
                "email": "trunghieu0107@gmail.com"
            }
        ]
    },
    "statusCode": 200
}
```

## Error example
```json
{
    "statusCode": 400,
    "message": "Department's ID cannot be null",
    "errKey": "ErrInvalidRequest"
}
```



