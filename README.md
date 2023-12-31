# sauce-labs-mobile-selenium-cucumber

### Project Overview:

This project is created for Challenge 8 of the Binar Academy x SYNRGY Academy QA bootcamp batch 6. Created by Shidqi Adiatma a.k.a hipstertester.

**Demo:** [Link to Demo Video]

## Project Overview:

- **Project Name:** sauce-labs-mobile-selenium-cucumber
- **Artifact ID:** sauce-labs-mobile-selenium-cucumber
- **Version:** 1.0-SNAPSHOT

## Dependencies:

1. **Cucumber:**
    - `io.cucumber:cucumber-java:7.11.1`
    - `io.cucumber:cucumber-testng:7.11.1`

2. **Java Faker:**
    - `com.github.javafaker:javafaker:1.0.2`

3. **Appium:**
    - `io.appium:java-client:8.3.0`

4. **Selenium:**
    - `org.seleniumhq.selenium:selenium-java:4.8.1`
    - `org.seleniumhq.selenium:selenium-api:4.8.1`
    - `org.seleniumhq.selenium:selenium-remote-driver:4.8.1`

5. **Commons IO:**
    - `commons-io:commons-io:2.11.0`

6. **SLF4J (Simple Logging Facade for Java):**
    - `org.slf4j:slf4j-simple:2.0.9` (used in the 'test' scope)

## Java and Maven Configuration:

- **Java Version:**
    - Source and target compatibility set to Java 20.

- **Maven Compiler Plugin:**
    - Version 3.11.0

- **Surefire Plugin:**
    - Version 3.0.0-M5
    - Configured to run TestNG tests specified in the `testng.xml` file.
    - Uses Maven properties, including the suite XML file (`testng.xml`).

## Folder Structure

The folder structure is as following:

    secondhand-web-selenium-cucumber
    ├─ report
    ├─ src
        ├─ main     
            ├─ java\com\shidqiadiatma
                ├─ factories             # Mobile & driver manager
                ├─ helpers               # Java faker & keyword selenium
        ├─ test
             ├─ java\com\shidqiadiatma
                ├─ features              # Gherkin test cases 
                ├─ pages                 # Page object
                ├─ runners               # Testng runner
                ├─ steps                 # Step definitions
            ├─ resources
    ├─ target                            # Reports are generated in the target/reports directory
    ├─ .gitignore
    ├─ pom.xml
    ├─ README.MD
    ├─ testng.xml


## Getting Started:

To get started, follow these simple steps:

1. Clone the repository to your local machine.

```bash
git clone https://github.com/shidqiadiatma/sauce-labs-mobile-selenium-cucumber.git
```

## How to Run:

1. Using Maven CLI

```bash
mvn test
```

## Reporting:

I'm using extentreport for reporting, and file report will be generated in the 'target/reports' directory.

---
