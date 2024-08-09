Project Name: Automation Testing for OrangeHRM using Java, Selenium, Cucumber, and TestNG

Project Description: This project is an automated testing suite developed for the OrangeHRM application using Java, Selenium, Cucumber, and TestNG. The goal of this project is to ensure the reliability and functionality of various features within the OrangeHRM system by automating repetitive and critical test cases.
OrangeHRM is a popular open-source human resource management system that includes features like employee management, leave management, and more. This testing suite focuses on validating core functionalities such as user authentication, employee management, job title management, and role-based access control.
By leveraging Cucumber's behavior-driven development (BDD) approach, the project allows for easy collaboration between technical and non-technical stakeholders, making the test scenarios easily understandable and maintainable. Selenium WebDriver is used to interact with the web elements, while TestNG is used for executing the test cases and generating reports.
The project is designed to be scalable and extensible, making it easy to add new test scenarios and integrate with continuous integration tools like GitHub Actions for automated test execution in a CI/CD pipeline.

Objectives: The objective of this project is to thoroughly test the various functionalities of the OrangeHRM application through automation. By leveraging Java, Selenium, Cucumber, and TestNG, this project automates key test cases such as user authentication, employee management, and job title administration. The automation suite aims to ensure that the application is reliable, efficient, and meets the required business requirements, while also facilitating continuous integration and easier maintenance of the test cases.

Technologies Used
   Programming Language: Java
   Automation Tools: Selenium, Cucumber, TestNG
   Build Tool: Maven or Gradle (mention the one you are using)
   Version Control: Git
   CI tool: Github Actions
   CD: Docker

Prerequisites:
The software and tools that need to be installed before running the project:
Java JDK (19 or above)
Maven or Gradle
Git
IDE (e.g., IntelliJ IDEA, Eclipse)
BrowserDriver (e.g., ChromeDriver, GeckoDriver)

Project Structure:
src/test/java/base: Contains the base steps
src/test/java/pages: Contains all the pages of the application, eg. Login Page, Job Title Page, Pay Grades page etc.
src/test/java/runners: Contains the runner file for execution of the test cases.
src/test/java/StepDefinition: Contains the definition of the feature files

src/test/resources/executables: Contains the drivers for different browsers
src/test/resources/featureFiles: Contains different feature files in Cucumber
src/test/resources/properties: Contains the property files for configuration
src/test/resources/reports: Contains the reports (Extent Report and Cucumber reports). Please check this folder after the execution of the test cases for reports
src/test/resources/runner: Contains the testng xml file for the execution

pom.xml or build.gradle: Build configuration file.
testng.xml: TestNG configuration file.

Running the Tests:
For running the tests, first you need to update the TestRunner file which is present in src/test/resources/runner/TestRunner and specify which
feature files you need to execute. The feature files are present in src/test/resources/featureFiles. If you want to execute all the feature files
then just mention the path of featureFiles directory.

Then, go to testng xml file and execute the file.

Continuous Integration: The tests can also be executed using Github actions by workflows. The workflow has workflow dispatch, which allows us to execute it through manual trigger

Continuous Deployment: The code can finally be deployed into a docker image. This project has the docker file which extracts the artifacts from the target folder and deploys it into the docker image.