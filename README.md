# SpringBoot project of Naver's course

## APIs
1. [Department APIs (v1)](#department-apis-v1)
   1. [GET - Get Departments](#get---get-departments)
   2. [GET - Get Department by ID](#get---get-department-by-id) 
   3. [POST - Create new Department by ID](#post---create-new-department-by-id)
   4. [PUT - Update Department by ID](#put---update-department-by-id)
   5. [DELETE - Delete Department by ID](#delete---delete-department-by-id)
2. [Employee APIs (v1)](#employee-apis-v1)
   1. [GET - Get Employees](#get---get-employees)
   2. [GET - Get Employee by ID](#get---get-employee-by-id)
   3. [POST - Create new Employee by ID](#post---create-new-employee-by-id)
   4. [PUT - Update Employee by ID](#put---update-employee-by-id)
   5. [DELETE - Delete Employee by ID](#delete---delete-employee-by-id)
3. [Department API (v2)](#department-apis-v2)
   1. [GET - Get Department by ID with MyBatis](#get---get-department-by-id-with-mybatis)
4. [Employee API (v2)](#employee-apis-v2)
   1. [GET - Get Employee by ID with MyBatis](#get---get-employee-by-id-with-mybatis)
5. [Factory Method APIs](#factory-method-apis)
   1. [GET - Get computer type](#get---get-computer-type)
6. [Error Response](#error-response)
## Department APIs v1
   ### GET - Get Departments
   * Request api/departments
   * Response
   ```json
{
   "data": [
      {
         "departmentId": 1,
         "name": "IT Department",
         "description": "For developers"
      }
   ],
   "statusCode": 200
}
   ```
   ### GET - Get Department by ID
   * Request api/department/1
   * Response
   ```json 
{
    "data": {
        "departmentId": 1,
        "name": "IT Department",
        "description": "For developers",
        "employees": [
            {
                "employeeId": 1,
                "name": "Trung Hieu",
                "birthday": "01-07-2001",
                "gender": "MALE"
            }
        ]
    },
    "statusCode": 200
}
   ```
   ### POST - Create new Department by ID
   * Request api/department
   ```json
{
   "name" : "IT Department",
   "description" : "For devs"
}
   ```
   * Response
   ```json
{
   "data": {
      "departmentId": 1,
      "name": "IT Department",
      "description": "For devs",
      "employees": []
   },
   "statusCode": 200
}
   ```
   ### PUT - Update Department by ID
   * Request api/department/1
   ```json
{
   "description" : "For developers"
}
   ```
   * Response
   ```json
{
   "data": "true",
   "statusCode": 200
}
   ```
   ### DELETE - Delete Department by ID
   * Request api/department/1
   * Response
   ```json
{
   "data": "true",
   "statusCode": 200
}
   ```
## Employee APIs v1
   ### GET - Get Employees
   * Request api/employee
   * Response
   ```json
{
   "data": [
      {
         "employeeId": 2,
         "name": "Trung Hieu",
         "birthday": "30-06-2001",
         "gender": "MALE"
      }
   ],
   "statusCode": 200
}
   ```
   ### GET - Get Employee by ID
   * Request api/employee/1
   * Response
   ```json
{
   "data": {
      "employeeId": 1,
      "name": "Trung Hieu",
      "birthday": "01-07-2001",
      "gender": "MALE",
      "department": {
         "departmentId": 1,
         "name": "IT Department",
         "description": "For devs"
         }
      }, 
   "statusCode": 200
}
   ```
   ### POST - Create new Employee by ID
   * Request api/employee
   ```json
{
   "name" : "Trung Hieu",
   "birthday" : "01-07-2001",
   "gender" : "MALE",
   "departmentId" : 1
}
   ```
   * Response
   ```json
{
   "data": {
      "employeeId": 1,
      "name": "Trung Hieu",
      "birthday": "01-07-2001",
      "gender": "MALE",
      "department": {
         "departmentId": 1,
         "name": "IT Department",
         "description": "For developers"
         }
      },
   "statusCode": 200
}
   ```
   ### PUT - Update Employee by ID
   * Request api/employee/1
   ```json
{
   "gender" : "OTHER",
   "departmentId" : 1
}
   ```
   * Response
   ```json
{
   "data": "true",
   "statusCode": 200
}
   ```
   ### DELETE - Delete Employee by ID
   * Request api/employee/1
   * Response
   ```json
{
   "data": "true",
   "statusCode": 200
}
   ```
## Department APIs v2
   ### GET - Get Department by ID with MyBatis
   * Request api/v2/department/:id
   * Response
   ```json
{
   "data": {
      "departmentId": 1,
      "name": "IT Department",
      "description": "For developers",
      "employees": [
         {
            "employeeId": 1,
            "name": "Trung Hieu",
            "birthday": "01-07-2001",
            "gender": "MALE"
         }
      ]
   },
   "statusCode": 200
}   
   ```
## Employee APIs v2
   ### GET - Get Employee by ID with MyBatis
   * Request api/v2/employee/1
   * Response
   ```json
{
   "data": {
      "employeeId": 1,
      "name": "Trung Hieu",
      "birthday": "01-07-2001",
      "gender": "MALE",
      "department": {
         "departmentId": 1,
         "name": "IT Department",
         "description": "For devs"
      }
   },
   "statusCode": 200
}
   ```
## Factory Method APIs
   ### GET - Get computer type
   * Request api/factory-method/PC
   * Response
   ```json
{
   "data": {
      "computer": "PC",
      "type": "PC"
   },
   "statusCode": 200
}
   ```
## Error Response
```json
{
    "statusCode": 400,
    "message": "Invalid data",
    "err_key": "ErrInvalidRequest"
}
```


