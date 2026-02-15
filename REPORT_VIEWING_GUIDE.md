# How to View Test Reports

This guide explains how to run tests and open the Allure report directly from your IDE. Follow the steps in order for a smooth setup every time.

## What you need

- Your IDE (VS Code / IntelliJ / similar)
- An IDE terminal opened in this project folder
- These tools installed: Java, Maven, Allure

### How to install them (Windows)

Run these commands in PowerShell:

```powershell
winget install -e --id EclipseAdoptium.Temurin.17.JDK
choco install maven -y
npm install -g allure-commandline
```

Then restart your IDE and verify:

```bash
java -version
mvn -v
allure --version
```

If you see versions numbers, you are ready.

## Before you start (inside IDE)

1. Open this project in your IDE.
2. Open the built-in terminal.
3. Make sure the terminal path is the project root (where `pom.xml` is).

---

## Step 1) Run UI and API tests separately

In the IDE terminal, run these commands in order:

```bash
mvn clean "-Dsurefire.suiteXmlFiles=testng.xml" "-Dallure.results.directory=target/allure-results-ui" test
mvn "-Dsurefire.suiteXmlFiles=testng-api.xml" "-Dallure.results.directory=target/allure-results-api" test
```

Wait until both finish. If you see `BUILD SUCCESS`, test runs are done.

---

## Step 2) Generate and open separate Allure reports

In the same IDE terminal, run:

```bash
allure generate target/allure-results-ui --clean -o allure-report-ui
allure open allure-report-ui -h 127.0.0.1 -p 5055

allure generate target/allure-results-api --clean -o allure-report-api
allure open allure-report-api -h 127.0.0.1 -p 5056
```

Both reports should open automatically in your default browser.

---

## If something does not work

### Problem: one of the reports is empty

Run the related suite command again (UI or API), then regenerate that report.

- UI results folder: `target/allure-results-ui`
- API results folder: `target/allure-results-api`

### Problem: command runs in the wrong folder

Make sure your IDE terminal is in the project root (the folder that contains `pom.xml`).

### Problem: `Address already in use: bind`

This means the selected port is already in use.

Use a different port:

```bash
allure open allure-report-ui -h 127.0.0.1 -p 5057
```

This should also open automatically in your default browser.

Optional: close the old Allure window/process and try port `5055` again.
