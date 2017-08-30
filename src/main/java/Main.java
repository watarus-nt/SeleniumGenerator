import utils.AI_Script_File.WriteScriptFile;
import utils.AI_XML_File.WriteTestXML;

import java.io.File;

/**
 * Created by WataruS on 8/27/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length != 2){
            System.out.println("Please provide two input arguments when calling this application!");
            System.out.println("First argument is the destination where you want to store output files.");
            System.out.println("Second argument is the input json!");
        }
        String workingDirectory = args[0];
        String inputJson = args[1];

//        workingDirectory = "D:\\Books\\SourceCode\\SeleniumBase\\SeleniumPractices";
//        inputJson = "sampleAItest.json";

        System.out.println("Test script directory is :\"" + workingDirectory + "\"");
        System.out.println("Input Json file is :\"" + inputJson + "\"");

        WriteTestXML writeTestXML = new WriteTestXML();
        writeTestXML.createXml(workingDirectory, inputJson);
        writeTestXML.writeToFile(workingDirectory);

        WriteScriptFile writeScriptFile = new WriteScriptFile();

        writeScriptFile.generateTestScripts(workingDirectory);

    }


}
