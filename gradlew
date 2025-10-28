#!/bin/sh
##############################################################################
## Gradle start up script for UN*X
##############################################################################
APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`
DIRNAME=`dirname "$0"`
GRADLE_HOME="$DIRNAME"
CLASSPATH="$GRADLE_HOME/gradle/wrapper/gradle-wrapper.jar"
java -Xmx64m -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
