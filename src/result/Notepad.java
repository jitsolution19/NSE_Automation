package result;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Notepad {
	public static void main(String[] args){
	String filePath= "C:\\Users\\mamta\\eclipse-workspace\\NSE_INDIA\\Result\\TestResult";
	String value=readtextfile(filePath);
	System.out.println(value);
//		
//	BufferedWriter writer = null;
//    try {
//        //create a temporary file
//        String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//        File file = new File("C:\\Users\\mamta\\eclipse-workspace\\NSE_INDIA\\Result\\TestResult");
//        File logFile = new File(timeLog);
//
//        // This will output the full path where the file will be written to...
//        System.out.println(logFile.getCanonicalPath());
//
//        writer = new BufferedWriter(new FileWriter(logFile));
//        writer.write("Hello world!");
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            // Close the writer regardless of what happens...
//            writer.close();
//        } catch (Exception e) {
//        }
//    }
}
	public static String readtextfile(String filePath)
	{
		File file = new File(filePath);
		BufferedReader br;		
		String data = null;
		try {		
			br = new BufferedReader(new FileReader(file));
			while ((data = br.readLine()) != null)
			System.out.println(data);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;	 
			
	}
}
