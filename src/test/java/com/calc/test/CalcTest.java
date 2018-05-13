package com.calc.test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class CalcTest {
 
    @BeforeSuite
    public void setUp() throws Exception {
 
    }
 
    @AfterSuite
    public void tearDown() throws Exception {
    }
 
 
    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
            {  1, 2, 3 },
            {  2, 3, 4 },  // error or the data itself :)
            { -1, 1, 0 }
        };
    }
 
 
    @Test(dataProvider = "ValidDataProvider")
    @Xray(requirement = "CALC-1234", test = "TES-7")
    public void CanAddNumbersFromGivenData(final int a, final int b, final int c)
    {
        Assert.assertEquals(Calculator.Add(a, b), c);
    }
 
 
    @Test
    @Xray(requirement = "CALC-1234", test = "TES-8", labels = "core addition")
    public void CanAddNumbers()
    {
        Assert.assertEquals(Calculator.Add(1, 1),2);
        Assert.assertEquals(Calculator.Add(-1, 1),0);
    }
 
 
    @Test
    @Xray(requirement = "CALC-1235", labels = "core")
    public void CanSubtract()
    {
        Assert.assertEquals(Calculator.Subtract(1, 1), 0);
        Assert.assertEquals(Calculator.Subtract(-1, -1), 0);
        Assert.assertEquals(Calculator.Subtract(100, 5), 95);
    }
 
 
    @Test
    @Xray(requirement = "CALC-1236")
    public void CanMultiplyX()
    {
        Assert.assertEquals(Calculator.Multiply(1, 1), 1);
        Assert.assertEquals(Calculator.Multiply(-1, -1), 1);
        Assert.assertEquals(Calculator.Multiply(100, 5), 500);
    }
 
 
    @Test
    @Xray(requirement = "CALC-1237")
    public void CanDivide()
    {
        Assert.assertEquals(Calculator.Divide(1, 1), 1);
        Assert.assertEquals(Calculator.Divide(-1, -1), 1);
        Assert.assertEquals(Calculator.Divide(100, 5), 20);
    }
 
 
    @Test
    public void CanDoStuff()
    {
        Assert.assertNotEquals(true, true);
    }
 
}