package TestNGPrg;

import org.testng.annotations.Test;

public class DataProvider {
	
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String destination)
	{
		System.out.println("Book Tickets from "+src+" to "+destination);
	}

	
	@org.testng.annotations.DataProvider
	public Object[][] getData() {
	{
		Object [][] objArr = new Object[2][2];
		
		objArr[0][0] = "Chennai";
		objArr[0][1] = "Hyderabad";
		
		objArr[1][0] = "Chennai";
		objArr[1][1] = "Hyderabad";
		
	return objArr;
	}

}}
