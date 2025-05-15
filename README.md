# cucumber-json-server-api

## Run Automated Tests
To run the tests use maven command:
```  
mvn clean test  
```  

## Generate Test Report
Allure framework is used to generate report from test results - https://github.com/allure-framework/allure-maven

To serve test report on local machine make sure you have run tests using `mvn clean test` command before, then use below command:
```  
allure serve allure-results 
```

