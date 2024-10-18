package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.spi.SLF4JServiceProvider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ticket {
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.google.co.in");
		
//		driver.get("http://gemini-service-tnp.tndev.aws.gartner.com/services/v2/export/top/occ8?rows=1000&Country=US");
//		WebElement code =driver.findElement(By.className("token-property"));
//		
//		for (String string : args) {
//			String occ_code= code.getText();
//			System.out.println(occ_code);
	}

}

