package Demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest 
{
	@Test
	public void launch()
	{
		Reporter.log("SampleTest executed",true);
		Reporter.log("Modification executed",true);
		
	}

}
