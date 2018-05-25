package result;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;

public class htmlResult {
	static File junitReport;
	static BufferedWriter junitWriter;
	
	
	@Test
	public void Setup(){
		
		String Path= System.getProperty("user.dir");
		htmlResult ht= new htmlResult();
		
		String testcaseName=ht.getClassName();
		System.out.println(Path+"\\Result\\"+testcaseName+".html");
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		Date date = new Date();
		String junitReportFile= Path+"\\Result\\"+testcaseName+".html";
		junitReport = new File(junitReportFile);
		try {
			junitWriter = new BufferedWriter(new FileWriter(junitReport, true));
			junitWriter.write("<!DOCTYPE html><html>");
			junitWriter.write("<h1 align=\"center\" style=\"background-color:DodgerBlue;\">Test Execution Summary - " + dateFormat.format(date)+ "</h1>");	
			junitWriter.write("<h2 style=\"background-color:DodgerBlue;\"><span style=\"float:left;\">TestCase Name :: Testing </span><span style=\"float:right;\">Executed By :: Jitendra</span></h2>");
			junitWriter.write("<head><style>table, th, td {border: 1px solid black;border-collapse: collapse;}th, td {padding: 15px;}</style></head>");
			junitWriter.write("<body>");
			
			junitWriter.write("<table style=\"width:100%\">");
			junitWriter.write("<th>S.no#</th><th>Test Case Name</th><th>Expected Result</th><th>Actual Result</th><th>Status</th><th>Start Time</th><th>End Time</th>");
			junitWriter.write("<tr>");
			junitWriter.write("<td align=\"center\">1</td>");
			junitWriter.write("<td>Verify User Name</td>");
			junitWriter.write("<td>jitsolution19@gmail.com</td>");
			junitWriter.write("<td>jitsolution19@gmail.com</td>");
			junitWriter.write("<td align=\"center\">Pass</td>");
			junitWriter.write("<td align='center'>"+LocalDateTime.now()+"</td>");
			junitWriter.write("<td align=\"center\">12:45:00 AM</td>");
			junitWriter.write("</tr>");
			junitWriter.write("</table>");
			junitWriter.write("</body></html>");
			
			junitWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

	
	
	
	public String getClassName() {
        String className = this.getClass().getSimpleName(); 
        System.out.println("Name:" + className);
		return className;
    }
}
