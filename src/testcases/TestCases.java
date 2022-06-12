package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCases {
	

	
	private WebDriver driver;
	private String SeleniumTitle = "Selenium";
	private String WikipediaTitle = "Wikipedia, la enciclopedia libre";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test_WikipediaSeleniumTitle() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		WebElement searchButton = driver.findElement(By.id("searchButton"));
		
		searchInput.sendKeys("selenium");
		searchButton.click();
		
		WebElement title = driver.findElement(By.id("firstHeading"));
		String StringTitle = title.getText();
		
		
		assertEquals(SeleniumTitle, StringTitle);
	}
	
	@Test
	public void test_WikipediaRandom() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		WebElement randomPage = driver.findElement(By.linkText("Página aleatoria"));

		randomPage.click();
		
		driver.navigate().back();
		;
		String StringTitle = driver.getTitle();
		
		
		assertEquals(WikipediaTitle, StringTitle);
	}
	
	@After
	public void shutdown() {
		driver.quit();
	}

}
