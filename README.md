# Selenium WebDriver with Java (TestNG + Cucumber + Allure)

This repository contains UI and API test automation for https://the-internet.herokuapp.com/.

Core approach:

- Java 17 + Maven
- Selenium WebDriver for UI
- Rest Assured for API
- Cucumber + TestNG runners
- Allure reporting
- Page Object Model for UI pages

## Table of Contents

- [Overview](#overview)
- [Cucumber Status](#cucumber-status)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Run Tests](#run-tests)
- [Reports](#reports)
- [CI Pipeline](#ci-pipeline)
- [Linting](#linting)
- [Troubleshooting](#troubleshooting)

## Overview

UI coverage includes scenarios such as context menu, alerts, dropdown, dynamic loading, slider, hover, key presses, login, and WYSIWYG editor interactions.

API coverage currently includes a Cucumber health-check flow.

UI akışı:

- TestNG suite: `testng.xml`
- Runner: `e2e.cucumber.CucumberTestRunner`
- Features: `src/test/resources/features`
- Steps: `src/test/java/e2e/cucumber/steps`
- Hooks: `src/test/java/e2e/cucumber/hooks`

API akışı:

- TestNG suite: `testng-api.xml`
- Runner: `api.cucumber.ApiCucumberTestRunner`
- Features: `src/test/resources/api/features`
- Steps: `src/test/java/api/cucumber/steps`
- Hooks: `src/test/java/api/cucumber/hooks`

## Tech Stack

- Java 17
- Maven
- Selenium WebDriver
- TestNG
- Cucumber (`cucumber-java`, `cucumber-testng`)
- Rest Assured
- Allure (`allure-cucumber7-jvm`, `allure-java-commons`)
- SLF4J + Logback

## Project Structure

```text
.
├── .github/workflows/pr-tests.yml
├── pom.xml
├── testng.xml
├── testng-api.xml
├── REPORT_VIEWING_GUIDE.md
├── package.json
├── eslint.config.js
└── src
    ├── main/java
    │   ├── constants
    │   │   └── HomeLinks.java
    │   └── pages
    │       ├── BasePage.java
    │       ├── HomePage.java
    │       └── ...
    └── test
        ├── java
        │   ├── e2e
        │   │   ├── base
        │   │   │   └── AllureListener.java
        │   │   ├── cucumber
        │   │   │   ├── CucumberTestRunner.java
        │   │   │   ├── CucumberTestContext.java
        │   │   │   ├── hooks
        │   │   │   └── steps
        │   │   └── utils
        │   │       └── ConfigReader.java
        │   └── api
        │       ├── client
        │       └── cucumber
        │           ├── ApiCucumberTestRunner.java
        │           ├── context
        │           ├── hooks
        │           └── steps
        └── resources
            ├── config.properties
            ├── logging.properties
            ├── features
            └── api/features
```

## Prerequisites

- Java 17+
- Maven
- Google Chrome
- Allure CLI (for local report viewing)

Optional (only for lint):

- Node.js + npm

Verify installation:

```bash
java -version
mvn -v
allure --version
```

## Configuration

Default config file:

- `src/test/resources/config.properties`

Current keys:

```properties
baseUrl=https://the-internet.herokuapp.com/
username=tomsmith
password=SuperSecretPassword!
```

Override priority:

1. Java system property (`-Dusername=...`)
2. Environment variable with `E2E_` prefix (`E2E_USERNAME=...`)
3. Value from `config.properties`

## Run Tests

Run all tests (default surefire suite in `pom.xml`):

```bash
mvn clean test
```

Run UI suite only:

```bash
mvn "-Dsurefire.suiteXmlFiles=testng.xml" "-Dallure.results.directory=target/allure-results-ui" test
```

Run API suite only:

```bash
mvn "-Dsurefire.suiteXmlFiles=testng-api.xml" "-Dallure.results.directory=target/allure-results-api" test
```

## Reports

Detailed guide:

- `REPORT_VIEWING_GUIDE.md`

Quick commands:

```bash
allure generate target/allure-results-ui --clean -o allure-report-ui
allure open allure-report-ui -h 127.0.0.1 -p 5055

allure generate target/allure-results-api --clean -o allure-report-api
allure open allure-report-api -h 127.0.0.1 -p 5056
```

## CI Pipeline

PR workflow file: `.github/workflows/pr-tests.yml`

Current behavior:

- Trigger: `pull_request` (`opened`, `synchronize`, `reopened`, `ready_for_review`)
- Skips draft PRs
- Runs UI suite and API suite separately
- Uploads artifacts:
  - Surefire reports
  - UI Allure HTML report
  - API Allure HTML report

## Linting

If you are editing JavaScript tooling/config files, run:

```bash
npm install
npm run lint
```

## Troubleshooting

### `allure` command not found

- Install Allure CLI
- Restart terminal/IDE
- Re-run `allure --version`

### Port already in use (`Address already in use: bind`)

Use a different port:

```bash
allure open allure-report-ui -h 127.0.0.1 -p 5057
```

### Empty report

Re-run the related suite (UI or API), then regenerate the corresponding report directory.
