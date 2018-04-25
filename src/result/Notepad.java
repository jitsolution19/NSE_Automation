package result;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Notepad {
	static String FolderPath="C:\\Users\\mamta\\eclipse-workspace\\NSE_INDIA\\Result";
	public static void main(String[] args){
	String filePath= FolderPath+"\\input.txt";
	String value=readtextfile(filePath);
	System.out.println(value);
	
	String testCaseName="TC01_Test";
	String text ="Hello World";
	writetextfile(FolderPath,testCaseName,text);
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
			e.printStackTrace();
		}
		return data;	 
			
	}
	
	public static void writetextfile(String FolderPath,String testCaseName,String text)
	{
		BufferedWriter writer = null;		
		String timeLog = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());	
		File resultfile = new File(FolderPath+"\\"+testCaseName+"_"+timeLog+".txt");
		try {
			writer = new BufferedWriter(new FileWriter(resultfile));
			writer.write(text);
		} catch (IOException e) {	
			e.printStackTrace();
		}finally {
	      try {
//	       Close the writer regardless of what happens...
	      writer.close();
	  } catch (Exception e)
	     {
		  e.printStackTrace();
	     }
	  }	
	}
}
