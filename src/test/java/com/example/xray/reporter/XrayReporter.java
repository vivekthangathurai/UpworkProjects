package com.example.xray.reporter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import com.example.xray.client.XrayClient;

public class XrayReporter implements IReporter {

	private final static Logger LOGGER = Logger.getLogger(XrayReporter.class.getName());
	
	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {
		
		XrayClient client = new XrayClient();
		try{
		client.basicAuth("***username***","***password****");
		client.exportTestngResult("TES","target/surefire-reports/testng-results.xml");
		}catch(Exception ex){
			LOGGER.log(Level.SEVERE,"Xray API failed to upload results",ex);
		}

	}

}
