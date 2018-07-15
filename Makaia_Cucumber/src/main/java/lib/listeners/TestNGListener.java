package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class TestNGListener implements IAnnotationTransformer, IRetryAnalyzer {

		int maxrerun = 1;
	@Override
	public void transform(ITestAnnotation annotation, 
			Class testClass, 
			Constructor testConstructor, 
			Method testMethod) {

		/*if (testMethod.getName().equals("DeleteLead"))
		{
			annotation.setEnabled(false);
			System.out.println(testMethod.getName()+"disabled for execution!");
		}*/
		
		/*if (testMethod.getName().equals("createLead"))
		{
			annotation.setTimeOut(5000);
		}*/
		annotation.setRetryAnalyzer(this.getClass());

	}

	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess() && maxrerun < 2)
		{
			maxrerun++;
			return true;
		}
		return false;
	}


}

	
	
	
	
