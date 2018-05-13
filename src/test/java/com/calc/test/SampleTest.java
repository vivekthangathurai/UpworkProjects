package com.calc.test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
 
public class SampleTest {
 
    @BeforeSuite
    public void setUp() throws Exception {
 
    }
 
    @AfterSuite
    public void tearDown() throws Exception {
    }
 
 
    @Test
    @Xray(test = "TES-7")
    public void CanAddNumbersFromGivenData()
    {
        Assert.assertEquals(Calculator.Add(1,2), 4);
    }
 
 
    @Test
    @Xray(test = "TES-8")
    public void CanAddNumbers()
    {
        Assert.assertEquals(Calculator.Add(1, 1),2);
        Assert.assertEquals(Calculator.Add(-1, 1),0);
    }
 
 
 
}