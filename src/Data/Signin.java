package Data;
import Data.TestData;
import Data.Screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;


public class Signin {

	TestData t= new TestData(); //Objet to use the data from TestData
	String username = t.usernamefield ; //WebElement for Texbox of Username
	String password=t.passwordfield; //WebElement for Texbox of Password
	String signbttn=t.signbttn; //WebElement for Button
	String weburl=t.weburl; //Url of Webpage
	static Screenshot s= new Screenshot();


	//Method to Obtain User and Password to singing to the webpage
	public Signin(String user, String pass) throws IOException {
		String path = "C:\\Automation Drivers\\chromedriver.exe"; //Chrome Driver Path
		System.setProperty("webdriver.chrome.driver", path);
		ChromeDriver d= new ChromeDriver();
		d.get(weburl);
		d.findElementByXPath(username).sendKeys(user); //Obtain the User data from the Test Case and put into textbox of the webpage
		d.findElementByXPath(password).sendKeys(pass); //Obtain the Password data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(signbttn).click();
		Signin.s.ScreenShot(d);
		d.close();
	}

	
}
