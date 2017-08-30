SET "seleniumProjectPath=D:\Books\SourceCode\SeleniumBase\SeleniumPractices"

java -jar SeleniumGenerator.jar %seleniumProjectPath% sampleAItest.json

cd %seleniumProjectPath%

mvn clean verify -DtestSuiteXML=ai.xml > debug.txt

echo Done!


PAUSE
