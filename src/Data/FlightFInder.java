package Data;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.graph.ElementOrder.Type;

public class FlightFInder {

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
	String RoundTriptype= r.RoundTriptype;
	String Onewaytype= r.Onewaytype;
	String passenger= r.passenger;
	String departingplace=r.departingplace;
	String departingmont = r.departingmont;
	String departingday = r.departingday;
	String arriving= r.arriving;
	String returningmonth= r.returningmonth;
	String returningday=r.returningday;
	String FirstClass= r.FirstClass;
	String BusinessClass=r.BusinessClass;
	String EconomyClass=r.EconomyClass;
	String airline=r.airline;
	String findfligthbttn = r.findfligthbttn;
	String continuef=r.continuef;
	static Screenshot s= new Screenshot();
	
	public FlightFInder(String flightype, String passenger, String departingplace, String departingmonth, String departingday, String arriving, String returningmonth, String returningday , String classtype, String airline) throws IOException {
		ReadExcel re= new ReadExcel("C:\\Automation Data\\TestData.xlsx"); 
		String firstname=re.getData("Register", 1, 0);
		String lastname=re.getData("Register", 1, 1);
		String phone=re.getData("Register", 1, 2);
		String email=re.getData("Register", 1, 3);
		String address=re.getData("Register", 1, 4);
		String city=re.getData("Register", 1, 5);
		String state=re.getData("Register", 1, 6);
		String zipcode=re.getData("Register", 1, 7);
		String countryselect=re.getData("Register", 1, 8);
		String usernamer=re.getData("Register", 1, 9);
		String passwordr=re.getData("Register", 1, 10);
		String cpasswordr=re.getData("Register", 1, 11);		
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
		
		d.findElementByLinkText("Flights").click();
		if (flightype=="Round Trip") {
			
			d.findElementByXPath(this.RoundTriptype).click();
		}
		else {
			d.findElementByXPath(this.Onewaytype).click();
		}
		
		Select listpassenger = new Select(d.findElementByXPath(this.passenger));
		listpassenger.selectByVisibleText(passenger);
		Select listdepartingplace = new Select(d.findElementByXPath(this.departingplace));
		listdepartingplace.selectByVisibleText(departingplace);
		Select listdepartingmonth = new Select(d.findElementByXPath(this.departingmont));
		listdepartingmonth.selectByVisibleText(departingmonth);
		Select listdepartingday = new Select(d.findElementByXPath(this.departingday));
		listdepartingday.selectByVisibleText(departingday);
		Select listarriving = new Select(d.findElementByXPath(this.arriving));
		listarriving.selectByVisibleText(arriving);
		Select listreturningmonth = new Select(d.findElementByXPath(this.returningmonth));
		listreturningmonth.selectByVisibleText(returningmonth);
		Select listreturningday = new Select(d.findElementByXPath(this.returningday));
		listreturningday.selectByVisibleText(returningday);
		if (classtype=="Economy") {
			
			d.findElementByXPath(this.EconomyClass).click();
		}
		if (classtype=="Business") {
			d.findElementByXPath(this.BusinessClass).click();
		}
		else {
			d.findElementByXPath(this.FirstClass).click();
		}
		Select listairline = new Select(d.findElementByXPath(this.airline));
		listairline.selectByVisibleText(airline);
		d.findElementByXPath(findfligthbttn).click();
		Register.s.ScreenShot(d);
		d.findElementByXPath(continuef).click();
		Register.s.ScreenShot(d);
	}
	
}
