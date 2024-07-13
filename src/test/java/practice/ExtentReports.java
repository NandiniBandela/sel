package practice;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class ExtentReports {
	@Test
	public void homepage(Method mtd) {
		
		Reporter.log(mtd.getName()+"Test Start");
//		Reporter.log("step-7");
//		Reporter.log("step-14");
//		Reporter.log("step-21");
//		Reporter.log("step-28");
		
		Reporter.log("step-7",true);
		Reporter.log("step-14",true);
		Reporter.log("step-21",true);
		Reporter.log("step-28",true);
		Reporter.log(mtd.getName()+"Test End");

	}

	

}
