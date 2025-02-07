package Campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.protobuf.Duration;

public class DemoWebShop {
	
	@Test()
	public void shop()
	{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));
	driver.get("https://demowebshop.tricentis.com/");
	
	}


}
