package result;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlReportGenerator {

	public static void main(String[] args) {

		String File_Location = "C:\\Users\\LENOVO\\git\\NSE_Automation\\Result\\XmlReport.xml";
		File file = new File(File_Location);
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element Report = doc.createElement("Report");
			doc.appendChild(Report);

			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			Date date = new Date();

			Element rootElement2 = doc.createElement("ProjectName");
			rootElement2.appendChild(doc.createTextNode("Report Creation"));
			Report.appendChild(rootElement2);

			Element rootElement1 = doc.createElement("ReportHeadline");
			rootElement1.appendChild(doc.createTextNode("Test Execution Summary"));
			Report.appendChild(rootElement1);

			Element DaterootElement = doc.createElement("ProjectStartDate");
			DaterootElement.appendChild(doc.createTextNode(dateFormat.format(date)));
			Report.appendChild(DaterootElement);

			Element rootElement3 = doc.createElement("TesterName");
			rootElement3.appendChild(doc.createTextNode("Jeetendra Gupta"));
			Report.appendChild(rootElement3);

			Element scenario = doc.createElement("ScenarioName");
//			scenario.setAttribute("Sequence", "1");
			scenario.appendChild(doc.createTextNode("Test Scenario"));
			Report.appendChild(scenario);

			Element TestCaseName = doc.createElement("TestCaseName");
//			TestCaseName.setAttribute("Number", "1");
			TestCaseName.appendChild(doc.createTextNode("Test Case Name"));
			scenario.appendChild(TestCaseName);

			Element TestStep = doc.createElement("Teststep");
			TestStep.appendChild(doc.createTextNode("1"));
			TestCaseName.appendChild(TestStep);

			Element TestStepCondtion = doc.createElement("TestStepCondtion");
			TestStepCondtion.appendChild(doc.createTextNode("Verify Login button"));
			TestCaseName.appendChild(TestStepCondtion);

			Element ExpectedCondition = doc.createElement("ExpectedCondition");
			ExpectedCondition.appendChild(doc.createTextNode("Login Button Should Present"));
			TestCaseName.appendChild(ExpectedCondition);

			Element ActualCondition = doc.createElement("ActualCondition");
			ActualCondition.appendChild(doc.createTextNode("Login Button is Present"));
			TestCaseName.appendChild(ActualCondition);

			Element StepStatus = doc.createElement("StepStatus");
			StepStatus.appendChild(doc.createTextNode("Pass"));
			TestCaseName.appendChild(StepStatus);

			Element StartTime = doc.createElement("StartTime");
			SimpleDateFormat Starttime = new SimpleDateFormat("HH:mm:ss");
			Date now = new Date();
			String strTime = Starttime.format(now);
			StartTime.appendChild(doc.createTextNode(strTime));
			TestCaseName.appendChild(StartTime);

			Date EndNow = new Date();
			String end = Starttime.format(EndNow);
			Element EndTime = doc.createElement("EndTime");
			EndTime.appendChild(doc.createTextNode(end));
			TestCaseName.appendChild(EndTime);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			System.out.println("File saved!");

//			StreamResult consoleResult = new StreamResult(System.out);
//			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
