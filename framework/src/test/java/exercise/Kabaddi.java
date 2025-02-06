package exercise;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kabaddi {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.prokabaddi.com/standings");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		
		driver.findElement(By.className("close-btn")).click();
		
	    List<WebElement> teamdata = driver.findElements(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-play']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']/ancestor::div[@class='row-head']//div[@class='table-data matches-lost']/ancestor::div[@class='row-head']//div[@class='table-data matches-draw']"));
		
		for (int i = 3; i < teamdata.size(); i++) {
			
			System.out.println("team names" + teamdata.get(3).getText());
			
		}
		
	}

}
