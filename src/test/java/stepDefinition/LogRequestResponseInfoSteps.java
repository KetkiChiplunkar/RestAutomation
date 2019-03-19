package stepDefinition;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogRequestResponseInfoSteps {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Given("^the user wants to get the header information$")
	public void headerInfo() {

		request = given().log().headers();
	}
	
	@Given("^user wants to see the request information of this new student to be created$")
	public void requestInfo() {
// System.out.println("=========Request details==========");
//		request = given().log().all();
	
	}

	@Given("^the user wants to get the student with \"([^\"]*)\" as \"([^\"]*)\"$")
	public void the_user_wants_to_get_the_student_with_as(String arg1,
			String arg2) throws Throwable {
		request = given().param(arg1, arg2).param("limit", 1);
	}

	@Given("^the user want to get only \"([^\"]*)\" student with the given programme$")
	public void listStudent(String arg1) throws Throwable {
	//	request = given().param("limit",Integer.valueOf(arg1));
		
	}
	
	
	
	@When("^the user triggers get request$")
	public void getInfo() throws Throwable {
		response = request.when().get("/list");
	}

	@When("^the user triggers get request to see the student's information$")
	public void the_user_wants_to_see_the_header_information() throws Throwable {
		response = request.when().get("/2");
	}

	@Then("^the user gets the requested information$")
	public void the_header_information_is_visible_for_the_user()
			throws Throwable {
		System.out.println("response: " + response.prettyPrint());
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is "+statusCode);
		System.out.println("Response is as "+response.getBody().asString());
	}

}
