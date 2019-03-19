package stepDefinition;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

public class FormAuthentication {
	
	public static SessionFilter filter ;
	@BeforeTest
	public static void init(){
		/**
		 * filter object get the the session id 
		 */
		filter = new SessionFilter();
		RestAssured.baseURI ="http://localhost:8085/";
		//Here in the given enter username and password in the form auth config we need to provide the form action in the following 
		//it is as follows action="/login", element name in username field is uname and password as pwd 
		RestAssured.given().auth().form("user", "user", new FormAuthConfig("/login","uname","pwd")).
		filter(filter).
		get();
		System.out.println("Session Id is "+filter.getSessionId());
		
		
	}
@Test 
public void loginToSPI(){
	RestAssured.given().sessionId(filter.getSessionId()).get("/student/list").then().log().all();
	
}



}
