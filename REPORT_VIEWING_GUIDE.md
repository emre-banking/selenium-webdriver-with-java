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

## Step 1) Run all tests

In the IDE terminal, run:

```bash
mvn test
```

Wait until it finishes. If you see `BUILD SUCCESS`, tests are done.

---

## Step 2) Open the detailed report (Allure)

In the same IDE terminal, run:

```bash
allure generate allure-results --clean -o allure-report
allure open allure-report -h 127.0.0.1 -p 5055
```

The report should open automatically in your default browser.

---

## If something does not work

### Problem: report is empty

Run `mvn test` first, then generate Allure report again.

### Problem: command runs in the wrong folder

Make sure your IDE terminal is in the project root (the folder that contains `pom.xml`).

### Problem: `Address already in use: bind`

This means the port is already in use (usually `5055`).

Use a different port:

```bash
allure open allure-report -h 127.0.0.1 -p 5056
```

This should also open automatically in your default browser.

Optional: close the old Allure window/process and try port `5055` again.
