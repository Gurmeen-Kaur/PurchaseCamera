package com.SeleniumPractice.AssignmentOne;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaveenAutomobileShop {
	String emailGenerated;

	WebDriver driver;
	Actions action;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\Chrome Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();
	}
//this is new test
	@Test
	public void purchaseItem() {

		String parentWindowHandle = driver.getWindowHandle();

		WebElement myAccount = driver.findElement(By.cssSelector("#top-links a.dropdown-toggle"));
		myAccount.click();

		WebElement registerOption = driver.findElement(By.cssSelector("li.dropdown.open>ul>li:first-of-type a"));
		registerOption.click();

		WebElement inputFirstName = driver.findElement(
				By.cssSelector("form.form-horizontal #account div.form-group.required:nth-of-type(2)>div>input"));
		inputFirstName.sendKeys("Gurmeen");

		WebElement inputLastName = driver.findElement(
				By.cssSelector("form.form-horizontal #account div.form-group.required:nth-of-type(3)>div>input"));
		inputLastName.sendKeys("Kaur");
		WebElement emailInput = driver.findElement(
				By.cssSelector("form.form-horizontal #account div.form-group.required:nth-of-type(4)>div>input"));
		sleep();
		emailGenerated = randomEmail() + "@gmail.com";
		emailInput.sendKeys(emailGenerated);
		sleep();
		WebElement telephoneInput = driver.findElement(
				By.cssSelector("form.form-horizontal #account div.form-group.required:nth-of-type(5)>div>input"));
		telephoneInput.sendKeys("9876543210");
		sleep();
		WebElement passwordInput = driver.findElement(
				By.cssSelector("form.form-horizontal fieldset:nth-of-type(2)>div:first-of-type>div>input"));
		passwordInput.sendKeys("Password123");

		WebElement confirmPasswordInput = driver
				.findElement(By.cssSelector("form.form-horizontal fieldset:nth-of-type(2)>div:last-of-type>div>input"));
		confirmPasswordInput.sendKeys("Password123");

		WebElement subscribeButton = driver.findElement(
				By.cssSelector("form.form-horizontal fieldset:last-of-type>div>div>label:first-of-type>input"));
		subscribeButton.click();
		WebElement privacyCheckBox = driver.findElement(By.cssSelector("div.buttons>div input:first-of-type"));
		privacyCheckBox.click();

		WebElement continueButton = driver.findElement(By.cssSelector("div.buttons>div input:last-of-type"));
		continueButton.submit();
		sleep();
		WebElement continueBtn = driver.findElement(By.cssSelector("div.buttons>div>a"));
		continueBtn.click();
		sleep();
		WebElement cameraOption = driver.findElement(By.cssSelector("ul.nav.navbar-nav>li:nth-of-type(7)>a"));
		cameraOption.click();

		WebElement addToCartButton = driver
				.findElement(By.cssSelector("#content div.row:nth-of-type(2)>div:last-of-type button:first-of-type"));
		addToCartButton.click();

		driver.findElement(By.cssSelector("#cart>button")).click();
		driver.findElement(By.cssSelector("ul.list-inline>li:nth-of-type(4)>a>i")).click();
		driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

		sleep();
		WebElement firstName = driver.findElement(By.cssSelector("#input-payment-firstname"));
		sleep();
		firstName.sendKeys("Kevin");
		sleep();
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Hart");
		sleep();
		driver.findElement(By.id("input-payment-company")).sendKeys("ABC");
		sleep();
		driver.findElement(By.id("input-payment-address-1")).sendKeys("123 First Line");
		sleep();
		driver.findElement(By.id("input-payment-address-2")).sendKeys("Drive");
		sleep();
		driver.findElement(By.id("input-payment-city")).sendKeys("Ajax");
		sleep();
		driver.findElement(By.id("input-payment-postcode")).sendKeys("MLP3T");
		sleep();

		Select sc = new Select(driver.findElement(By.cssSelector("#input-payment-country")));

		sc.selectByVisibleText("Canada");
		sleep();
		Select sc1 = new Select(driver.findElement(By.id("input-payment-zone")));
		sleep();
		sc1.selectByVisibleText("Ontario");
		sleep();

		driver.findElement(By.id("button-payment-address")).click();
		sleep();
		driver.findElement(By.id("button-shipping-address")).click();
		sleep();
		driver.findElement(By.cssSelector("#collapse-shipping-method div.panel-body textarea"))
				.sendKeys("Please don't be late");
		sleep();
		driver.findElement(By.id("button-shipping-method")).click();
		sleep();
		driver.findElement(By.cssSelector("div.panel.panel-default:nth-of-type(5) textarea"))
				.sendKeys("Available Monday to Friday");
		sleep();
		driver.findElement(By.cssSelector("#collapse-payment-method>div>div.buttons input:first-of-type")).click();
		sleep();
		driver.findElement(By.id("button-payment-method")).click();
		sleep();
		driver.findElement(By.id("button-confirm")).click();
		sleep();
		driver.findElement(By.cssSelector("div.buttons a")).click();
		sleep();

	}

	@AfterMethod
	public void tearDown() {
//		driver.close();
	}

	public void sleep() {
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String randomEmail() {
		String characterString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder(10);

		for (int i = 0; i < 10; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (characterString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(characterString.charAt(index));
		}

		return sb.toString();
	}

}
