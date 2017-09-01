@echo off
SET "seleniumProjectPath=D:\Books\SourceCode\SeleniumBase\SeleniumPractices"

java -jar SeleniumGenerator.jar %seleniumProjectPath% sampleAItest.json

cd %seleniumProjectPath%

call mvn clean verify -DtestSuiteXML=ai.xml 

echo Done!
echo 

start %seleniumProjectPath%/testReports

PAUSE
