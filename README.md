# Overview

This Java project is made as a free distribution that works as the basis for a Selenium Testing Framework with the basic tools needed for Testing and Reporting and that can be used for e2e and component testing; this is merely a starting point for this tool and the purpose of this is to be as robust as it's complexity allos it. All the components needed for the execution are listed below and a brief introduction to his folder structure and his usage.

# Dependencies

The dependencies listed on this project are added on on the **POM.xml** file. Each one of this dependencies are needed for the correct usage of this repository.

- selenium-java@4.5.2

- webdrivermanager@5.3.0

- junit-jupiter-api@5.9.1

- extentreports@3.1.2

- json-simple@1.1.1


# Test Execution
For any **Java** + **Selenium** project, we need to have the following elements installed on the environment we are excuting our tests:

 - [Java JDK](https://www.oracle.com/java/technologies/downloads/).
 - [JAVA_HOME](https://www.java.com/en/download/help/path.html) environment variable on System Variables(Using the JDK path previously installed).
 - [Apache Maven](https://maven.apache.org/install.html).
 - [MAVEN_HOME](https://www.javatpoint.com/how-to-install-maven) environment variable on System Variables(Using the folder path from the project folder).

Additionally, we need to ensure we have a [ChromeDriver](https://chromedriver.chromium.org/) browser file in our project to make a reference on our code and launch an instance for testing purposes.

## On Visual Studio Code

For Visual Studio Code, we need to look for the Java Extension Pack on the Extension manager, once this is installed we can execute any Java based tests. Also we need to ensure the Text Explorer tab is available on our editor. 

Finally we will be using [JUnit](https://junit.org/junit5/) as a testing framework and listed on the Dependencies from [junit-jupiter-api](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api); using the **Annotations** listed on the [documentation](https://junit.org/junit5/docs/current/user-guide/) such as *@Test*, *@DisplayName*, *@BeforeEach*, *@AfterEach*, etc.

## On Maven

Maven is a tool that can now be used for building and managing any Java-based project, this let us easily execute our Selenium tests with the simple command `mvn test -Dtest=”TestClassName”`. For further details on execution for maven, please reference the proper [documentation](https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html).

# Folder Structure

    demo
    ├── src
    │   ├── main
    │   │   └── java
    │   │       └── com
    │   │           └── project
    │   └── test
    │       ├── java
    │       │   └── com
    │       │       └── project
    │       │           ├── fixtures
    │       │           │   └── ExtentReport
    │       │           │       └── Screenshots
    │       │           ├── integration
    │       │           │   └── e2e
    │       │           └── pagesAndActions
    │       │               └── common
    │       │                   ├── actions
    │       │                   └── pages
    │       └── resources
    └── target
    .editorconfig
    .gitignore
    pom.xml
    README.md

# Folder Structure Usage

All the test should be saved on the **integration** folder. The ***PagesAndActions*** folder contains subfolders for each one of the sections to be tested. Each one of this folder has two subfolders (***actions*** and ***pages***), the ***actions*** file has all the actions or flows made on a specific sections from the application and this file imports all the selectors, actions and validations from a specific file that is stored on the ***pages*** file.


## Change Log

|Date                           |Change                                                        |
|-------------------------------|--------------------------------------------------------------|
|22/10/2022                     |New selenium demo project. Create Basic navigation on Chromedriver.
|24/10/2022                     |Added reporting, screenshots and file loading fixtures.              |
|04/11/2022                     |Setting up the environment for automation using Selenium and ExtentReport.                  |
