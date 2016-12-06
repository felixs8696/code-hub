#!/bin/bash
# Root directory for absolute paths
GIT_ROOT_DIR=$(git rev-parse --show-toplevel)

# Get Test Runner Template
TEST_RUNNER_TEMPLATE="$GIT_ROOT_DIR/Templates/Java/jUnitTest/TestRunner.java"

# Remove all existing classes and TestRunner Files and recompile
if [ -f *.class ]; then
  rm *.class
fi
if [ -f TestRunner.java ]; then
  rm TestRunner.java
fi
javac *.java

# Get all Test Classes
TEST_CLASSES=`ls -m *Test.class`

# Replace ExampleTest with actual Test Classes in the current directory
TEST_RUNNER_CONTENT=$(<$TEST_RUNNER_TEMPLATE)
echo "$TEST_RUNNER_CONTENT" | sed -e "s/ExampleTest.class/${TEST_CLASSES}/g" >> TestRunner.java

javac *.java
java TestRunner

# Removes all class files and TestRunner file to keep version control clean
rm *.class
rm TestRunner.java
