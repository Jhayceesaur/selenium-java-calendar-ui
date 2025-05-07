import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarUIPractice 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String monthVal = "6";
		String dateVal = "15";
		String yearVal = "2027";
		String[] expectedList = {monthVal, dateVal, yearVal};
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation")).click();
		driver.findElement(By.xpath("//button[text()='"+ yearVal +"']")).click(); //Select year based on the string value
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthVal)-1).click(); //Select month based on the string value
		driver.findElement(By.xpath("//abbr[text()='"+ dateVal +"']")).click(); //Select date based on the string value
		
		List <WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for (int i = 0; i < actualList.size(); i++)
		{
			System.out.println(actualList.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
		}
		//driver.close();
	}
}
