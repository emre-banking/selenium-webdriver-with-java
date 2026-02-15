# Copilot Instructions

This repository contains UI test automation for `the-internet.herokuapp.com` using Java + Selenium + TestNG.

## Repository Layout (Use This As Source of Truth)

```text
src/
  main/java/
    constants/                 # enums/constants (e.g., home page links)
    pages/                     # Page Object classes
  test/java/e2e/
    base/                      # Base test setup, listeners
    utils/                     # Test utilities (e.g., config reader)
    actions/ alerts/ dropdown/ frames/ ...
                               # Feature-based test packages
  test/resources/
    config.properties          # Environment/test data config

.github/workflows/
  pr-tests.yml                 # CI pipeline for PR validation

testng.xml                     # Test suite orchestration
pom.xml                        # Dependency and build config
```

## File Placement Rules

- New page interactions go to `src/main/java/pages`.
- New E2E tests go under the relevant feature folder in `src/test/java/e2e/*`.
- Shared setup/listener logic stays in `src/test/java/e2e/base`.
- Shared helpers stay in `src/test/java/e2e/utils`.
- New configuration keys must be added to `src/test/resources/config.properties` and accessed via `ConfigReader`.

## Coding Standards

- Use Java 17-compatible code.
- Keep changes small, focused, and directly related to the request.
- Do not introduce hard-coded sleeps; prefer explicit waits.
- Reuse existing Page Object methods before adding new ones.
- Keep naming consistent with existing classes (`*Page`, `*Tests`).
- Avoid broad refactors unless explicitly requested.

## Selenium/Test Design Rules

- Keep assertions in test classes or explicit `assert*` page methods (follow existing style).
- Prefer stable locators (`id`, reliable CSS) before XPath when possible.
- Use Allure steps for important actions/assertions (consistent with current codebase).
- Any flaky fallback logic must be explicit and narrowly scoped to the known scenario.

## Test Execution

- Local run: `mvn test`
- Suite source: `testng.xml`
- CI run: `.github/workflows/pr-tests.yml`

## Reporting

- Allure is used for test reporting.
- Local report flow:
  - `allure generate allure-results --clean -o allure-report`
  - `allure open allure-report -h 127.0.0.1 -p 5055`
- If port `5055` is busy, use `5056`.
- CI uploads Allure HTML artifact; prefer consuming artifact output instead of committing generated files.

## CI/Workflow Constraints

- Keep PR workflow changes minimal and purpose-driven.
- Preserve test execution on pull requests.
- Artifacts should be upload-only outputs; never commit generated report folders.

## Contribution Notes

- Preserve existing naming and package conventions.
- Avoid unrelated refactors in the same change.
- Update documentation when behavior, setup, or workflows change.
- Keep generated artifacts out of commits (`allure-results/`, `allure-report/`, `target/`).

## Definition of Done (For Code Changes)

- Code is placed in the correct folder per rules above.
- `mvn test` passes locally (or known blocker is explicitly stated).
- CI-impacting changes are reflected in workflow/docs when needed.
- No generated files are left in git changes.
