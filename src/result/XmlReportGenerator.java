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
	static String File_Location;
	static File file;
	static DocumentBuilderFactory docFactory;
	static DocumentBuilder docBuilder;
	static Document doc;
	static Element Report;
	static TransformerFactory transformerFactory;
	static Boolean ScenarioStatus;
	static Boolean TestCaseStatus;
	static Element reportobj;
	static Element scenario;
	static Element TestCaseName;

	public static void main(String[] args) {

		File_Location = "C:\\Users\\LENOVO\\git\\NSE_Automation\\Result\\XmlReport.xml";
		file = new File(File_Location);
		try {
			reportobj = reportSetup("Report Generation", "Jitendra");
			ScenarioName("Scenario 1");
			TestCaseName("Test Case 1");
			TestStep("1","Verify Login","Login Success","Login Success","Pass");
			TestStep("2","Verify Product Added","Product Added Success","Product Added Success","Pass");
			TestStep("3","Verify Product dispaly in Cart","Product dispaly in Cart Success","Product dispaly in Cart Success","Pass");
			TestCaseName("Test Case 2");
			TestStep("1","Verify Login","Login Success","Login Success","Pass");
			TestStep("2","Verify Product Added","Product Added Success","Product Added Success","Pass");
			TestStep("3","Verify Product dispaly in Cart","Product dispaly in Cart Success","Product dispaly in Cart Success","Pass");
			ScenarioName("Scenario 2");
			TestCaseName("Test Case 1");
			TestStep("1","Verify Login","Login Success","Login Success","Pass");
			TestStep("2","Verify Product Added","Product Added Success","Product Added Success","Pass");
			TestStep("3","Verify Product dispaly in Cart","Product dispaly in Cart Success","Product dispaly in Cart Success","Pass");
			ScenarioName("Scenario 3");
			TestCaseName("Test Case 1");
			TestStep("1","Verify Login","Login Success","Login Success","Pass");
			TestStep("2","Verify Product Added","Product Added Success","Product Added Success","Pass");
			TestStep("3","Verify Product dispaly in Cart","Product dispaly in Cart Success","Product dispaly in Cart Success","Pass");
			reportClosure();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Element reportSetup(String ProjectName, String TesterName) {
		try {
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			Report = doc.createElement("Report");
			doc.appendChild(Report);

			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			Date date = new Date();

			Element rootElement2 = doc.createElement("ProjectName");
			rootElement2.appendChild(doc.createTextNode(ProjectName));
			Report.appendChild(rootElement2);

			Element rootElement1 = doc.createElement("ReportHeadline");
			rootElement1.appendChild(doc.createTextNode("Test Execution Summary"));
			Report.appendChild(rootElement1);

			Element DaterootElement = doc.createElement("ProjectStartDate");
			DaterootElement.appendChild(doc.createTextNode(dateFormat.format(date)));
			Report.appendChild(DaterootElement);

			Element rootElement3 = doc.createElement("TesterName");
			rootElement3.appendChild(doc.createTextNode(TesterName));
			Report.appendChild(rootElement3);
		} catch (Exception e) {
			System.out.println(e);
		}
		return Report;
	}

	public static void ScenarioName(String ScenarioName) {
		scenario = doc.createElement("ScenarioName");
		scenario.appendChild(doc.createTextNode(ScenarioName));
		reportobj.appendChild(scenario);
	}

	public static void TestCaseName(String TestName) {
		TestCaseName = doc.createElement("TestCaseName");
//		TestCaseName.setAttribute("Number", "1");
		TestCaseName.appendChild(doc.createTextNode(TestName));
		scenario.appendChild(TestCaseName);
	}

	public static void TestStep(String sno,String Condition,String Expected,String Actual,String status) {
		Element TestStep = doc.createElement("Teststep");
		TestStep.appendChild(doc.createTextNode(sno));
		TestCaseName.appendChild(TestStep);

		Element TestStepCondtion = doc.createElement("TestStepCondtion");
		TestStepCondtion.appendChild(doc.createTextNode(Condition));
		TestCaseName.appendChild(TestStepCondtion);

		Element ExpectedCondition = doc.createElement("ExpectedCondition");
		ExpectedCondition.appendChild(doc.createTextNode(Expected));
		TestCaseName.appendChild(ExpectedCondition);

		Element ActualCondition = doc.createElement("ActualCondition");
		ActualCondition.appendChild(doc.createTextNode(Actual));
		TestCaseName.appendChild(ActualCondition);

		Element StepStatus = doc.createElement("StepStatus");
		StepStatus.appendChild(doc.createTextNode(status));
		TestCaseName.appendChild(StepStatus);

		Element StartTime = doc.createElement("TimeStamp");
		SimpleDateFormat Starttime = new SimpleDateFormat("HH:mm:ss");
		Date now = new Date();
		String strTime = Starttime.format(now);
		StartTime.appendChild(doc.createTextNode(strTime));
		TestCaseName.appendChild(StartTime);
	}

	public static void reportClosure() {
		try {
			transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
			System.out.println("File saved!");
//		StreamResult consoleResult = new StreamResult(System.out);
//		transformer.transform(source, consoleResult);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
