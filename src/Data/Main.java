package Data;

import java.io.IOException;

public class Main {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ReadExcel re= new ReadExcel("C:\\Automation Data\\TestData.xlsx"); 
		String username= re.getData("Login", 1, 0);
		String password= re.getData("Login", 1, 1);
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
		String flightype=re.getData("Flight", 1, 0);
		String passenger= "2";
		String departingplace=re.getData("Flight", 1, 2);
		String departingmonth = re.getData("Flight", 1, 3);
		String departingday = "18";
		String arriving= re.getData("Flight", 1, 5);
		String returningmonth= re.getData("Flight", 1, 6);
		String returningday="1";
		String classtype= re.getData("Flight", 1, 8);
		String airline=re.getData("Flight", 1, 9);
	
		//TC Sign in on the webpage "Note: is not working the database"
		Signin s= new Signin(username,password);
		//TC to Register User
		Register r=new Register(firstname, lastname, phone,email,address,city,state,zipcode,countryselect,usernamer,passwordr,cpasswordr);
		//TC to Find Flight (Need user the register first because the database is not storing my credentials
		FlightFInder f=new FlightFInder(flightype,passenger,departingplace,departingmonth,departingday,arriving,returningmonth,returningday,classtype,airline);
	}

}
