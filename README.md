# Project restAssuredAPITesting API testing
## Description
This project was done in order to execute 12 test cases for an API inside the site https://jsonplaceholder.typicode.com

## Execution
### Step 1
Open the project folder and run the following command
```
mvn install
```

### Step 2
Once the mvn project has the packages, start the test with the following command
```
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```
### Results
You will see the test results in shell and You will find the html report in the generated target folder

The software will run the tests groups in paraller each one with a different thread


## Test suite
The test suite has two different groups of test cases divided by positive and negative test cases.

### Positive test cases

* Get all posts from post api
* Get post by id
* Get post comments by Id
* Get post comments by id whit url parameter
* Create post
* Put post by id
* Delete post
  
### Negative test cases
* Get post by id with non existed id
* Get post by id with wrong parameter
* Get post comments by Id with wrong parameter
* Get post comments by id whit url parameter with wrong parameter

