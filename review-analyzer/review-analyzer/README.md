# review-analyzer

Small Spring Boot application (Java 17) for analyzing reviews.

Prerequisites
- Java 17 JDK installed and on PATH. Verify with:

```powershell
java -version
javac -version
```

Quick start (Windows PowerShell)

```powershell
# Run tests
.\gradlew.bat test

# Build (creates runnable jar under build/libs)
.\gradlew.bat build

# Run the app (dev)
.\gradlew.bat bootRun

# Run the built jar
java -jar build/libs/review-analyzer-0.0.1-SNAPSHOT.jar
```

Notes
- The project uses the Gradle wrapper included in the repo. Always use `./gradlew` (or `./gradlew.bat` on Windows) to ensure consistent Gradle version.
- The main application class is `com.matheus.review_analyzer.ReviewAnalyzerApplication`.
- Package names use an underscore (`review_analyzer`) — keep this exact package when adding new classes.

If you'd like, I can add a GitHub Actions workflow to run the build/tests on push.
