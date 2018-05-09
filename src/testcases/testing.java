package testcases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testing {
@BeforeClass
public static void setup()
{
System.out.println("Before Class");
}
@Before
public void writeReport()
{
System.out.println("Before");	
}
@Test
public void tested()
{
System.out.println("Hello");	
}

@After
public void FinalReport()
{
System.out.println("After");	
}
@AfterClass
public static void Closing()
{
System.out.println("After Class");
}

}
