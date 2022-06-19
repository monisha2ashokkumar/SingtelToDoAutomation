
# Singtel ToDo MVC Automation

This repository contains an automation solution for Singtel Automation Coding Test. 
The customised automation solution is built using Behavior-driven development (BDD) approach using Cucumber, Java 8, Selenium 
WebDriver, Rest-Assured, Page Object design patterns, Maven, JUnit and third party libraries with rich usage of lambda expressions and 
method references.

## Features

1. Highly customizable configurations  
2. Drivers are self-managed
3. OS platform and Browser independent
4. Built-in report with detailed steps
5. Screenshots on fail based on config
6. Rerun of failed tests
7. Continuous integration using Maven

### Tools, libraries and patterns

* Cucumber-JVM: BDD framework
* Selenium WebDriver: Web automation
* WebDriverManager: Driver management
* DotEnv: Configuration management
* Customised Page Object Models: Design patterns
* Maven: Build tool
* JUnit: Unit framework
* Rest-Assured: Restful Api framework
* Java 8: Programming language
* Github: Version control
* Customised Cucumber built-in reports: Reporting

### Prerequisites

Minimum requirement to run the automation in local machine
* Java 8
* Maven
* Git (optional)

### Clone repo

1. Open Terminal or command line, `cd` to desired folder where the source code needs to be checkout
2. Run command
   `git clone https://github.com/monisha2ashokkumar/SingtelToDoAutomation.git` or download https://github.com/monisha2ashokkumar/SingtelToDoAutomation/archive/refs/heads/master.zip and extract it

### Steps to run in local

1. Navigate to source directory
2. Run command 
   > mvn clean test   
   
   Suite will run in **chrome** browser by default, to run on different browsers option 'browser' need to be passed via mvn command.   
   Example:
   
   >mvn clean test "-Dbrowser=firefox"

   > mvn clean test "-Dbrowser=edge"
        
3. Similarly, suite will execute all feature files by default, if needed can run feature based on different options, for more details [Click here](https://cucumber.io/docs/cucumber/api/#options)
   
   To run for specific tag
   >mvn test -Dcucumber.filters.tags=&lt;tag name&gt;
  
   Example:
   >mvn test "-Dcucmber.filter.tags=@add"
   > 
   > or
   > 
   >mvn test "-Dcucumber.filter.tags=@add and @refresh"

### Reports

A built-in cucumber report will be generated at 'src/reports/cucumber-reports.html'

Sample screenshot are attached below:

PASS:

![image](https://user-images.githubusercontent.com/31698049/174472943-6266d17b-8fe9-4fd2-8ffa-d379a5ad71d9.png)

![image](https://user-images.githubusercontent.com/31698049/174472851-90296281-86ed-4b7b-a974-0c50ec528757.png)

![image](https://user-images.githubusercontent.com/31698049/174472906-83535319-4118-4101-b240-43fed1c8c7a6.png)


### Rerun Failed Tests 

During test executions, if one or more tests are failed will be captured in 'src/reports/failedScenarios.txt'

To run failed tests, cucumber options will be used to rerun using command "-Dcucumber.features=@&lt;filePath&gt;"

Example:

>mvn test "-Dcucumber.features=@src/reports/failedScenarios.txt"
