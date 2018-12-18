package notepadConnector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;


import org.junit.Test;

public class ReadFromTxtFile {

	String FilePath="E:\\Selenium_Project\\database\\testingFile.txt";
	
	@Test()
	public void readtxt() 
	{
//		String file = new FileInputStream(FilePath);
		BufferedReader read;
		try {
			read = new BufferedReader(new java.io.FileReader(FilePath));
			String reader;		
			while((reader= read.readLine())!=null)
				System.out.println(reader);
			read.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test()
	public void writetextFile() throws Exception
	{
		String text = "SurName='Gupta'";
		FileWriter fw = new FileWriter(FilePath,true);
		BufferedWriter writer = new BufferedWriter(fw,2);
		writer.newLine();
		writer.write(text);
		writer.close();
		fw.close();
	}
	
}
