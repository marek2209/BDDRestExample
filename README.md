# BDDRestExample

Simple API tests using Cucumber, RestAssured and Frameworkium. for https://reqres.in api.


###### Perequisities
  - Java 8 
  - IntelliJ
  - Maven
  
In order to run tests by tags and generate allure report just open terminal where pom.xml is placed and type:
````
    mvn clean verify -Dcucumber.options="--tags @api"
    mvn allure:report
````

