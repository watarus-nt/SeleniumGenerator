package utils;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utility {

    public static boolean createFolder(String path) throws Exception {
        File theDir = new File(path.trim());

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            return theDir.mkdir();

        } else
            return false;
    }

    /**
     * Kill Process without log
     *
     * @param processName
     * @throws Exception
     * @author pminhhung
     */
    public static void killProcess(String processName) throws Exception {
        try {

            if (System.getProperty("os.name").startsWith("Windows")) {
                Runtime.getRuntime().exec("taskkill /F /IM " + processName.trim());
            } else if (System.getProperty("os.name").startsWith("Mac")) {
                Runtime.getRuntime().exec("killall " + processName.trim());
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Get date.
     *
     * @return Current date
     * @throws Exception
     */
    public static String getDate() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }


    /**
     * Get time.
     *
     * @return Current time
     * @throws Exception
     */
    public static String getTime() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void writeToFile(List<String> content, String filename, Boolean overwriteFlag){
        File file = new File(filename);
        // if file doesnt exists, then create it
        if (overwriteFlag) {
            try {
                file.createNewFile();
                FileWriter fw = null;
                try {
                    fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (String line : content) {
                        bw.write(line);
                        bw.newLine();
                    }
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Write content to " + filename + " succesfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String handleEscapeCharacters(String input){
        return StringEscapeUtils.escapeJava(input);
    }

    public static List<String> readFileLineByLine(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        List<String> res = new ArrayList<String>();
        //List<String> re = new ArrayList<String>();

        String line = null;
        while ((line = br.readLine()) != null) {
            res.add(line);
        }
        br.close();
        return res;
    }

}
