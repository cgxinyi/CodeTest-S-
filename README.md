
### Docker Desktop
1. Install Docker Desktop & wsl backend at https://docs.docker.com/docker-for-windows/install/
2. open cmd cd to project file directory
3. run "docker build -t springio/gs-spring-boot-docker ."
4. open docker desktop to run the application

### localhost 
### assumption superRate is input with integer(auto convert to decimal) 
### --post method
curl -k -X POST -H "Content-Type:application/json" -d "[{\"firstName\":\"David\",\"lastName\":\"Rudd\",\"annualSalary\":\"60050\",\"paymentMonth\":\"1\",\"superRate\":\"3\"},{\"firstName\":\"Ryan\",\"lastName\":\"Chen\",\"annualSalary\":\"120000\",\"paymentMonth\":\"1\",\"superRate\":\"5\"}]" http://localhost:8080/postpayslip 

### deployed environment post
curl -k -X POST -H "Content-Type:application/json" -d "[{\"firstName\":\"David\",\"lastName\":\"Rudd\",\"annualSalary\":\"60050\",\"paymentMonth\":\"1\",\"superRate\":\"3\"},{\"firstName\":\"Ryan\",\"lastName\":\"Chen\",\"annualSalary\":\"120000\",\"paymentMonth\":\"1\",\"superRate\":\"5\"}]" http://codeseis-env.eba-qckgkz8t.us-east-2.elasticbeanstalk.com/postpayslip

# CodeTest-Seis

This application is build with visual studio code
1. Install visual studio code
2. Install  Visual Studio Coding Pack for Java (https://code.visualstudio.com/docs/java/java-tutorial)
3. Install Java SDK tools
4. Set JAVA_home environment
5. Press F5 to run the application or run button on visual studio code to run the application.

Assumption that is made:
1.First name and last name should not contains any numbers.
2.This program only output one month pay slip and the month is whichever the user input the payment start month with MMM format.
3.Annual Salary and super rate will not accept any string but numbers only.
4.Annual Salary will not exceed 1,000,000,000.



