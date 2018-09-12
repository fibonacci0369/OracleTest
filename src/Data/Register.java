package Data;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Data.TestData;

public class Register {

	TestData r= new TestData(); //Objet to use the data from TestData
	String weburl=r.weburl; //Url of Webpage
	String firstname=r.firstname;
	String lastname= r.lastname;
	String phone=r.phone;
	String email=r.email;
	String address=r.address;
	String city=r.city;
	String state=r.state;
	String zipcode=r.zipcode;
	String countryselect=r.countryselect;
	String usernamer= r.usernamer;
	String passwordr= r.passwordr;
	String cpasswordr = r.cpasswordr;
	String submit = r.submit;
	static Screenshot s= new Screenshot();
	
	public Register(String firstname, String lastname, String phone, String email, String address, String city, String state, String zipcode, String countryselect, String usernamer, String passwordr, String cpasswordr) throws IOException {
		String path = "C:\\Automation Drivers\\chromedriver.exe"; //Chrome Driver Path
		System.setProperty("webdriver.chrome.driver", path);
		ChromeDriver d= new ChromeDriver();
		d.get(weburl);
		d.findElementByLinkText("REGISTER").click();
		d.findElementByXPath(this.firstname).sendKeys(firstname); //Obtain the User data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(this.lastname).sendKeys(lastname); //Obtain the Password data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(this.phone).sendKeys(phone); //Obtain the User data from the Test Case and put into the textbox of the webpage
		d.findElementByName(this.email).sendKeys(email); //Obtain the Password data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(this.address).sendKeys(address); //Obtain the User data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(this.city).sendKeys(city); //Obtain the Password data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(this.state).sendKeys(state); //Obtain the User data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(this.zipcode).sendKeys(zipcode); //Obtain the Password data from the Test Case and put into the textbox of the webpage
		Select listCountry = new Select(d.findElementByXPath(this.countryselect));
		listCountry.selectByVisibleText(countryselect);
		d.findElementByName(this.usernamer).sendKeys(usernamer); //Obtain the Password data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(this.passwordr).sendKeys(passwordr); //Obtain the User data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(this.cpasswordr).sendKeys(cpasswordr); //Obtain the Password data from the Test Case and put into the textbox of the webpage
		d.findElementByXPath(submit).click();
		Register.s.ScreenShot(d);
		d.close();
	}
	
}
