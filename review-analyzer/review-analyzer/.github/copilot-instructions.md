## Quick orientation for AI coding agents

This is a small Spring Boot (Java 17) web application scaffold. The goal of this file is to help an AI agent be immediately productive by documenting the concrete, discoverable patterns and commands used in this repository.

- Main entry: `src/main/java/com/matheus/review_analyzer/ReviewAnalyzerApplication.java` (Spring Boot @SpringBootApplication).
- Build: Gradle with wrapper. Wrapper files are present at the repo root (use the wrapper to ensure consistent Gradle version).
- Java / Spring versions: Java 17 toolchain declared in `build.gradle`, Spring Boot plugin version `3.5.6`.

Why this structure
- A single Spring Boot application class is the entrypoint. New HTTP controllers, services and repos should be added under the same package root `com.matheus.review_analyzer` so Spring's component scan picks them up by default.

Key files and places to change
- `build.gradle` — dependency management, Lombok is present as `compileOnly` + annotationProcessor. If you add Lombok-annotated classes, ensure IDE annotation processing is enabled.
- `src/main/resources/application.properties` — currently only `spring.application.name=review-analyzer`. No custom port or datasource is configured; assume defaults (HTTP port 8080).
- `src/main/resources/templates/` and `static/` — standard Spring Boot locations for server-side templates and static assets.
- Tests: `src/test/java/com/matheus/review_analyzer/ReviewAnalyzerApplicationTests.java` uses `@SpringBootTest`. Add slice tests (e.g., @WebMvcTest) when you want faster feedback for controllers.

Prerequisites
- JDK 17 must be installed and on PATH (the project declares Java 17 in `build.gradle`). If `java -version` fails, install a JDK (Temurin/Adoptium or another distribution) and re-run the Gradle wrapper.

Build / Run / Test (Windows PowerShell)
Use the Gradle wrapper in this repo root (Windows):

```powershell
.\gradlew.bat build     # compile + tests + jar
.\gradlew.bat bootRun   # run the app with Spring Boot (devtools enabled during development)
.\gradlew.bat test      # run unit/integration tests

# After build, runnable jar is at:
# build/libs/review-analyzer-0.0.1-SNAPSHOT.jar
java -jar build/libs/review-analyzer-0.0.1-SNAPSHOT.jar
```

Debugging notes
- The main class to run/debug in an IDE is `com.matheus.review_analyzer.ReviewAnalyzerApplication`.
- `spring-boot-devtools` is included as `developmentOnly` in `build.gradle` for hot reload during development when run with `bootRun` or from IDE run configurations.
- Lombok is compileOnly — enable annotation processing in the IDE to avoid missing methods/fields at compile-time.

Project-specific conventions and gotchas
- Package path uses an underscore (`review_analyzer`) which is unusual for Java package names. Keep the exact package name when adding classes to avoid package mismatch and component-scan problems.
- Lombok is present: prefer concise data classes using Lombok only when annotation processing is configured.
- Tests use JUnit Platform (configured by `tasks.named('test') { useJUnitPlatform() }`). Expect JUnit Jupiter tests.
- No external SDKs are currently present in code, but the project description mentions "OCI AI Language" in `build.gradle` description — any integration should add the appropriate SDK dependency and environment/configuration management (secrets or env vars) under `application.properties` or a secure secret manager.

Examples of where to add things
- New REST controller: `src/main/java/com/matheus/review_analyzer/controller/YourController.java` with `@RestController`.
- Service layer: `src/main/java/com/matheus/review_analyzer/service/YourService.java` with `@Service`.
- Repository: `src/main/java/com/matheus/review_analyzer/repository/` if JPA is added later.

Checklist for code changes (small, concrete, reproducible)
1. Add/modify code under `com.matheus.review_analyzer` package.
2. Update `build.gradle` only if you need new dependencies or annotation processors.
3. Run `.\gradlew.bat test` locally; fix failing tests.
4. Run `.\gradlew.bat build` and verify `build/libs/*` jar runs.

If anything in this file is unclear or you want me to expand examples (controller template, test template, or adding an OCI integration example), tell me which area to expand.
