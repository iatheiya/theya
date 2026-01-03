#!/usr/bin/env sh

set -e

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

GRADLE_WRAPPER_JAR="$(dirname "$0")/gradle/wrapper/gradle-wrapper.jar"

if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
  echo "ERROR: gradle-wrapper.jar is missing"
  echo "Run: gradle wrapper --gradle-version 9.2.1"
  exit 1
fi

exec java $DEFAULT_JVM_OPTS -jar "$GRADLE_WRAPPER_JAR" "$@"
