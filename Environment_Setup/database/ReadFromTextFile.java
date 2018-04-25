package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFromTextFile {

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
	
}
