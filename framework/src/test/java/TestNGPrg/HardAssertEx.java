package TestNGPrg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	
	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("A", "A");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	@Test
	public void m2()
	{
		String actData = "Bhaskar";
		String ExpData = "Bhaskar";
		
		Assert.assertEquals(actData, ExpData);
	}
	@Test
	public void m3()
	{
		int a=10;
		int b=10;
		
		Assert.assertEquals(a, b, "not equal");
		System.out.println("Values are equal");		
	}
	
	@Test
	public void m4()
	{
		int a=10;
		int b=1;
		
		Assert.assertNotEquals(a, b, "values are equal");
		System.out.println("Not equal");		
	}
	@Test
	public void m5()
	{	
		String actData = "TechMahindra";
		String ExpData = "TechMahindra";
		
		Assert.assertTrue(actData.equalsIgnoreCase(ExpData), "False==");
		System.out.println("True==");
	}
	
	@Test
	public void m6()
	{
		String actData = "Chennai";
		String ExpData = "chennai";
		
		Assert.assertFalse(actData.contains(ExpData), "Same values==");
		System.out.println("False value");
	}
	
	@Test
	public void m7()
	{
		String s = null;
		Assert.assertNull(s, "It is not null");
		System.out.println("It is null");
	}
	
	@Test
	public void m8()
	{
		String s = "qspiders";
		Assert.assertNull(s, "It is not null");
		System.out.println("It is null");
	}
	
	@Test
	public void m9()
	{
		String actData = "qspiders";
		Assert.assertNotNull(actData, "It is null");
		System.out.println("It is not null");
	}
	@Test
	public void m10()
	{
		String s="Hello";
		String s1 = "Hello";
		Assert.assertSame(s1, s, "Not same");
		System.out.println("Same values");
	}
	@Test
	public void m11()
	{
		String s="Hello";
		String s1 = "hello";
		Assert.assertSame(s1, s, "Not same");
		System.out.println("Same values");
	}
	
	@Test
	public void m12()
	{
		String s="Hello";
		String s1 = "hello";
		Assert.assertNotSame(s1, s, "same values");
		System.out.println("Not same values");
	}
	
	@Test
	public void m13()
	{
		String s="Hello";
		String s1 = "Hell";
		Assert.assertNotSame(s1, s, "same");
		System.out.println("Not Same values");
	}
	
	@Test
	public void m14()
	{
		Assert.fail("Im failing the script");
	}
	
}
