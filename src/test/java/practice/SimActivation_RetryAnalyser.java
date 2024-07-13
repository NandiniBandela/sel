package practice;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class SimActivation_RetryAnalyser {

	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImp.class)
	public void activatesim() {
		System.out.println("Started");
		Assert.assertEquals(" ", "Login");
		System.out.println("Ended");
		
	}
}
