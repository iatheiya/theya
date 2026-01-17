@echo off
setlocal

set GRADLE_WRAPPER_JAR=%~dp0gradle\wrapper\gradle-wrapper.jar

if not exist "%GRADLE_WRAPPER_JAR%" (
  echo ERROR: gradle-wrapper.jar is missing
  echo Run: gradle wrapper --gradle-version 9.3.0
  exit /b 1
)

java -Xmx64m -Xms64m -jar "%GRADLE_WRAPPER_JAR%" %*
