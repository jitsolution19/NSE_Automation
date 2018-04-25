package database;

public class Testing {

	public static void main(String[] args) {
		String currentDirectory=System.getProperty("user.dir");
		String filePath= currentDirectory+"\\Result\\input.txt";		
		String value=database.ReadFromTextFile.readtextfile(filePath);
		System.out.println(value);
		
	}

}
