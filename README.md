# Selenium WebDriver with Java (TestNG + Cucumber + Allure)

A UI test automation project built with Java, Selenium WebDriver, TestNG, and Cucumber.

This repository validates common UI scenarios on [the-internet.herokuapp.com](https://the-internet.herokuapp.com/) using the Page Object Model (POM), with Allure integration for rich reporting.

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Run Tests Locally](#run-tests-locally)
- [View Reports](#view-reports)
- [CI Pipeline](#ci-pipeline)
- [Troubleshooting](#troubleshooting)

## Overview

The project includes end-to-end tests for flows such as:

- Context menu / click actions
- JavaScript alerts
- Dropdown selection
- iFrame editor interactions
- Hover behaviors
- Key press capture
- Login flow
- Dynamic loading / waits
- Horizontal slider interactions

Key design choices:

- **Page Object Model** for maintainable UI interactions
- **TestNG suite execution** via `testng.xml`
- **BDD support with Cucumber** (Gherkin feature files + step definitions)
- **Allure reporting** for detailed execution insights
- **Headless CI mode** triggered by `CI=true`

## Tech Stack

- Java 17+ (project compiles for Java 17)
- Maven
- Selenium WebDriver `4.38.0`
- TestNG `7.10.2`
- Cucumber (`cucumber-java` + `cucumber-testng`)
- Allure TestNG `2.27.0`
- Allure Cucumber 7 JVM `2.27.0`
- SLF4J + Logback

## Project Structure

```text
.
├── .github/workflows/pr-tests.yml
├── pom.xml
├── testng.xml
├── REPORT_VIEWING_GUIDE.md
├── src
│   ├── main/java
│   │   ├── constants
│   │   └── pages
│   └── test
│       ├── java/e2e
│       │   ├── actions
│       │   ├── alerts
│       │   ├── base
│       │   ├── dropdown
│       │   ├── frames
│       │   ├── horizontalslider
│       │   ├── hover
│       │   ├── keypresses
│       │   ├── login
│       │   ├── utils
│       │   └── wait
│       └── resources/config.properties
└── README.md
```

## Prerequisites

Install the following before running tests:

- Java (17+)
- Maven
- Google Chrome browser
- Allure CLI (for local report viewing)

### Verify installation

```bash
java -version
mvn -v
allure --version
```

> If `allure` is not recognized, install Allure CLI and restart your IDE/terminal.

## Configuration

Default test configuration is in:

- `src/test/resources/config.properties`

Current keys:

```properties
baseUrl=https://the-internet.herokuapp.com/
username=tomsmith
password=SuperSecretPassword!
```

You can update this file for different environments or test users.

Override order is:

1. Java system property (e.g. `-Dusername=...`)
2. Environment variable with `E2E_` prefix (e.g. `E2E_USERNAME=...`)
3. Value from `config.properties`

Examples:

```bash
mvn test -DbaseUrl=https://the-internet.herokuapp.com/ -Dusername=tomsmith -Dpassword=SuperSecretPassword!
```

```bash
# Linux / macOS
export E2E_USERNAME=tomsmith
export E2E_PASSWORD=SuperSecretPassword!
mvn test
```

```powershell
# Windows PowerShell
$env:E2E_USERNAME="tomsmith"
$env:E2E_PASSWORD="SuperSecretPassword!"
mvn test
```

## Run Tests Locally

From the project root:

```bash
mvn clean test
```

What this does:

- Runs TestNG suite defined in `testng.xml`
- Executes Cucumber scenarios through `e2e.cucumber.CucumberTestRunner`
- Executes tests in parallel by class (`thread-count=10`)
- Writes standard results to `target/surefire-reports`
- Writes Allure raw results to `target/allure-results`

## Cucumber Structure

- Feature files: `src/test/resources/features`
- Cucumber runner: `src/test/java/e2e/cucumber/CucumberTestRunner.java`
- Step definitions: `src/test/java/e2e/cucumber/steps`
- Hooks (driver lifecycle): `src/test/java/e2e/cucumber/hooks`

## View Reports

For IDE-focused report usage, see:

- `REPORT_VIEWING_GUIDE.md`

Quick local commands:

```bash
allure generate target/allure-results --clean -o allure-report
allure open allure-report -h 127.0.0.1 -p 5055
```

If port `5055` is already used, run:

```bash
allure open allure-report -h 127.0.0.1 -p 5056
```

## CI Pipeline

PR workflow:

- File: `.github/workflows/pr-tests.yml`
- Trigger: PR events (`opened`, `synchronize`, `reopened`, `ready_for_review`)
- Skips draft PRs (`if: github.event.pull_request.draft == false`)
- Runs `mvn -B test`
- Uploads artifacts:
  - `surefire-reports-<run_number>`
  - `allure-report-<run_number>` (generated in single-file mode)

This allows opening the CI report directly from workflow artifacts.

## Troubleshooting

### 1) `allure` command not found

- Install Allure CLI
- Restart IDE / terminal
- Re-run `allure --version`

### 2) `Address already in use: bind`

Another process is already using the selected port.

Use a different port:

```bash
allure open allure-report -h 127.0.0.1 -p 5056
```

### 3) Report looks blank when opened from ZIP temp path

Extract the downloaded artifact first, then open `index.html` from the extracted folder.

### 4) Browser startup issues in CI/local

Tests use `ChromeDriver` with Chrome options and headless mode in CI (`CI=true`).
Make sure Chrome is installed locally and compatible with your environment.
