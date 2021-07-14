#!/bin/sh
JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=${PROFILE:-dev}"

exec java $JAVA_OPTS -jar /app.jar