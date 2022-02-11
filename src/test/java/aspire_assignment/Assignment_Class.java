package aspire_assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class Assignment_Class {

	static String Inventory = "Inventory";
	static String MFg = "Manufacturing";
	static String Create = "Create";
	static String CreateProducrPageString = "Products";
	public static WebDriver driver;

	@BeforeTest
	public static void setDriver() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		
		System.setProperty("webdriver.gecko.driver", path+"\\src\\main\\resources\\drivers\\geckodriver.exe");

		//Creating an object of ChromeDriver
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://aspireapp.odoo.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}


	public static void loginandfinishthetestcase() throws InterruptedException, AWTException {

		System.out.println("------Test started--------");
		System.out.println("Entering Email-Id in email field");
		WebElement email = driver.findElement(By.xpath("//input[@id='login']"));
		email.clear();
		email.sendKeys("user@aspireapp.com");

		System.out.println("Entering Password in password field");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		password.sendKeys("@sp1r3app");

		System.out.println("Clicking on login button");
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Log in']"));
		loginBtn.click();

		System.out.println("Clicking on Inventory option");
		String displayed = driver.findElement(By.xpath("//div[normalize-space()='Inventory']")).getText();


		if (displayed.equalsIgnoreCase(Inventory)) {

			System.out.println("Inventory option is display and hence login is successful");
		}else {

			System.out.println("Login is not successful");
		}

		WebElement Inventry = driver.findElement(By.xpath("//div[normalize-space()='Inventory']"));
		Inventry.click();



		System.out.println("Clicking on Product link");
		WebElement productBtn = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
		productBtn.click();


		WebElement subProdctBtn = driver.findElement(By.xpath("//a[text()='Products']"));
		subProdctBtn.click();

		Thread.sleep(3000);


		System.out.println("Creating Product");
		String displayed1 = driver.findElement(By.xpath("//button[normalize-space()='Create']")).getText();

		if (displayed1.equalsIgnoreCase(Create)) {

			System.out.println("Navigated successfully to create page");
		}else {

			System.out.println("Navigation to creation page failed");
		}

		WebElement createBtn = driver.findElement(By.xpath("//button[normalize-space()='Create']"));
		createBtn.click();


		Thread.sleep(5000);

		String createPage = driver.findElement(By.xpath("//a[text()='Products']")).getText();


		if (createPage.equalsIgnoreCase(createPage)) {


			System.out.println("Navigated to create Product page successfully");
		}else {

			System.out.println("Navigation to create Product page failed");
		}


		System.out.println("Entering product name");
		WebElement productName = driver.findElement(By.xpath("//input[1][@name='name']"));
		productName.clear();
		productName.sendKeys("Parota");

		Thread.sleep(3000);


		WebElement saveBtn = driver.findElement(By.xpath("//button[@title='Save record']"));
		saveBtn.click();

		Thread.sleep(3000);

		System.out.println("Updating quantity");
		WebElement updateQuantiyBtn = driver.findElement(By.xpath("//span[text()='Update Quantity']"));
		updateQuantiyBtn.click();

		Thread.sleep(3000);

		WebElement createBtn1 = driver.findElement(By.xpath("//button[normalize-space()='Create']"));
		createBtn1.click();

		Thread.sleep(3000);

		WebElement noofQnty = driver.findElement(By.xpath("//input[@name='inventory_quantity']"));
		noofQnty.clear();
		noofQnty.sendKeys("100");

		Thread.sleep(3000);

		WebElement saveBtn1 = driver.findElement(By.xpath("//button[@title='Save record']"));
		saveBtn1.click();

		Thread.sleep(3000);

		System.out.println("Clicking on Home menu");
		WebElement homeMenu = driver.findElement(By.xpath("//a[@title='Home menu']"));
		homeMenu.click();

		Thread.sleep(3000);


		System.out.println("Clicking on Manufcturing card");
		String displayed2 = driver.findElement(By.xpath("//div[normalize-space()='Manufacturing']")).getText();


		if (displayed2.equalsIgnoreCase(MFg)) {

			System.out.println("Manufacturing option is visible");
		}else {

			System.out.println("Manufacturing option is not visible");
		}

		WebElement Manufacturing = driver.findElement(By.xpath("//div[normalize-space()='Manufacturing']"));
		Manufacturing.click();

		Thread.sleep(3000);

		System.out.println("Creating order");
		WebElement createBtn2 = driver.findElement(By.xpath("//button[normalize-space()='Create']"));
		createBtn2.click();

		Thread.sleep(3000);


		WebElement product_id = driver.findElement(By.xpath("(//input[starts-with(@id,'o_field_input_')])[1]"));


		product_id.click();

		System.out.println("click worked");
		product_id.sendKeys("parota");

		Thread.sleep(3000);

		WebElement product_id1 = driver.findElement(By.xpath("//a[text()='Parota']"));



		product_id1.click();

		Thread.sleep(3000);

		Actions action = new Actions(driver); 

		WebElement ele= driver.findElement(By.xpath("(//span[text()='New'])[2]"));
		Thread.sleep(3000);

		action.moveToElement(ele).click().perform();

		WebElement clickck = driver.findElement(By.xpath("//button[@name='action_confirm']"));
		clickck.click();
		Thread.sleep(3000);

		WebElement quantiy = driver.findElement(By.xpath("(//input[starts-with(@id,'o_field_input_')])[1]"));
		quantiy.click();
		
		quantiy.clear();
		
		Thread.sleep(3000);
		quantiy.sendKeys("40");
		
		Thread.sleep(3000);
		
		WebElement markasDone = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		
		markasDone.click();
		
		Thread.sleep(3000);
		
		String orderNo = driver.findElement(By.xpath("//span[@placeholder='Manufacturing Reference']")).getText();
		System.out.println(orderNo);
				
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
		
			
		Thread.sleep(3000);

		WebElement homeMenu1 = driver.findElement(By.xpath("//a[@title='Home menu']"));
		homeMenu1.click();
		//		
		String displayed3 = driver.findElement(By.xpath("//div[normalize-space()='Manufacturing']")).getText();


		if (displayed3.equalsIgnoreCase(MFg)) {

			System.out.println("Manufacturing option is visible");
		}else {

			System.out.println("Manufacturing option is not visible");
		}


		driver.findElement(By.xpath("//div[normalize-space()='Manufacturing']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//i[@title='Remove']")).click();
		//		
		Thread.sleep(3000);
		System.out.println("Searching for created order");
		WebElement searchOrderNo = driver.findElement(By.xpath("//input[@placeholder='Search...']"));

		searchOrderNo.clear();
		Thread.sleep(3000);
		searchOrderNo.sendKeys(orderNo);

		Thread.sleep(3000);

		searchOrderNo.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		System.out.println("Verifying the order presence");
		WebElement orderNoVerification = driver.findElement(By.xpath("//td[@name='name']"));
		String no = orderNoVerification.getText();

		if  (no.equalsIgnoreCase(orderNo)) {
			System.out.println("Order created successfully");
		}else {
			System.out.println("Order creation failed");
		}

		System.out.println("------Test Finished--------");
	}



	@AfterTest
	public static void close() {
		driver.close();
	}



}
