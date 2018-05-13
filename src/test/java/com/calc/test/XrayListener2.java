package com.calc.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.example.pojos.TestRun;
import com.example.pojos.UpdateTestRun;
import com.example.xray.client.XrayClient;
 
/**
 * The listener interface for receiving Xray events.
 * The Listener can be automatically invoked when TestNG tests are run by using ServiceLoader mechanism.
 * You can also add this listener to a TestNG Test class by adding
 * <code>@Listeners({com.xpand.java.XrayAnnotationListener.class})</code>
 * before the test class
 *
 * @see Xray
 */
public class XrayListener2 implements IInvokedMethodListener, ITestListener  {
    
	private XrayClient client;
    private final static Logger LOGGER = Logger.getLogger(XrayListener2.class.getName()); 
     
    /* (non-Javadoc)
     * @see org.testng.IInvokedMethodListener#beforeInvocation(org.testng.IInvokedMethod, org.testng.ITestResult)
     */
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    	
    	
        if(method.isTestMethod() && annotationPresent(method, Xray.class) ) {
            testResult.setAttribute("requirement", method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(Xray.class).requirement()); 
            testResult.setAttribute("test", method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(Xray.class).test());
            testResult.setAttribute("labels", method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(Xray.class).labels());
        }
    }
 
     
    private boolean annotationPresent(IInvokedMethod method, Class clazz) {
        boolean retVal = method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(clazz) ? true : false;
        return retVal;
    }
 
     
    /* (non-Javadoc)
     * @see org.testng.IInvokedMethodListener#afterInvocation(org.testng.IInvokedMethod, org.testng.ITestResult)
     */
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    	
    	if(method.isTestMethod()){
          switch (testResult.getStatus()) {
          
          case 1 :
        	  updateTestRun(testResult,"PASS");
        	  break;
          case 2 :
        	  updateTestRun(testResult,"FAIL");
          }
    	}
    }
 
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
         
    }
 
    public void onTestSuccess(ITestResult result) {
         
    }
 
    public void onTestFailure(ITestResult result) {
         
    }
 
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
         
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
         
    }
 
    public void onStart(ITestContext context) {
         client = new XrayClient();
    }
 
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
         
    }
    
    public void updateTestRun(ITestResult result,String status){
    	String execKey = System.getProperty("testExecKey");
    	if(execKey == null){
    		return;
    	}
    	
    	Object testKey = result.getAttribute("test");
    	if(testKey != null && testKey instanceof String){
    		client.basicAuth("***username***","***password****");
    		try{
    		TestRun run = client.getTestRun(execKey,(String)testKey);
    		UpdateTestRun update = new UpdateTestRun();
    		update.setStatus(status);
    		client.updateTestRun(Integer.toString(run.getId()),update);
    		}catch(Exception ex){
    		  LOGGER.log(Level.SEVERE,"Could not log TEST RUN", ex);
    		}
    	}
    }
     
}
