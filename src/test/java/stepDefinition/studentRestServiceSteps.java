package stepDefinition;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import RestClasses.Student;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class studentRestServiceSteps {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private Student student = new Student();

	@Given("^user gives base Url$")
	public void user_gives_base_Url() throws Throwable {
		request = given();
	}

	@Given("^the user provide resource$")
	public void the_user_provide_resource() throws Throwable {
		// RestAssured.basePath="/student/";
	}

	@When("^the user request Get method$")
	public void the_user_request_Get_method() throws Throwable {
		// response = request.when().get(endPointURL);
		response = request.when().get("/list");

	}

	@Then("^the user gets the list of all students$")
	public void the_user_gets_the_list_of_all_students() throws Throwable {
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("^the user gets the status code as \"([^\"]*)\"$")
	public void the_user_gets_the_status_code_as(String arg1) throws Throwable {
		json = response.then().statusCode(Integer.valueOf(arg1));

	}

	@Given("^a user provides base URI and resources$")
	public void a_user_provides_base_URI_and_resources() throws Throwable {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
		System.out.println("------Request Information is as follows-------");
		//request = given().contentType(ContentType.JSON).log().all(); //Prints the request details in the console
		request = given().contentType(ContentType.JSON).log().ifValidationFails();//print the request details when validation fails refer LogRequestResponseInfo.feature scenario #4
	}

	@When("^user gives student first name as \"([^\"]*)\"$")
	public void user_gives_student_first_name_as(String arg1) throws Throwable {
		student.setFirstName(arg1);

	}

	@When("^user gives student last name as \"([^\"]*)\"$")
	public void user_gives_student_last_name_as(String arg1) throws Throwable {
		student.setLastName(arg1);
	}

	@When("^user provides it email address as \"([^\"]*)\"$")
	public void user_provides_it_email_address_as(String arg1) throws Throwable {
		student.setEmailAddress(arg1);
	}

	@When("^user provides sets programmer as \"([^\"]*)\"$")
	public void user_provides_it_programmer(String arg1) throws Throwable {
		student.setprogramme(arg1);
	}

	@When("^user provides its course information as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provides_its_course_information_as_and(String arg1,
			String arg2) throws Throwable {
		List<String> list = new ArrayList<String>();
		list.add(arg1);
		list.add(arg2);
		student.setCourses(list);
	}

	@When("^user triggers the post request$")
	public void user_triggers_the_post_request() throws Throwable {
		response = request.when().body(student).post();
	}

	@Then("^user is able to create student$")
	public void user_is_able_to_create_student() throws Throwable {
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("^user gets the status code as \"([^\"]*)\"$")
	public void user_gets_the_status_code_as(String arg1) throws Throwable {
		json = response.then().statusCode(Integer.valueOf(arg1));
	}

	@When("^user provides its updated email address as \"([^\"]*)\"$")
	public void user_provides_its_updated_email_address_as(String arg1)
			throws Throwable {
		student.setEmailAddress(arg1);
	}

	@When("^user provides its course information as \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provides_its_course_information_as_and(String arg1,
			String arg2, String arg3) throws Throwable {
		List<String> list = new ArrayList<String>();
		list.add(arg1);
		list.add(arg2);
		list.add(arg3);
		student.setCourses(list);

	}

	@When("^user triggers the put request$")
	public void user_triggers_the_put_request() throws Throwable {
		response = request.when().body(student).put("/101");
	}

	@Then("^user information is updated successfully with the status code as \"([^\"]*)\"$")
	public void user_information_is_updated_successfully_with_the_status_code_as(
			String arg1) throws Throwable {
		System.out.println("response: " + response.prettyPrint());
		json = response.then().statusCode(Integer.valueOf(arg1));
	}

	@When("^user updates the email address information for student id \"([^\"]*)\"$")
	public void user_updates_the_email_address_information_for_student_id(
			String arg1) throws Throwable {
		student.setEmailAddress("updatedEmail@123.com");
		response = request.when().body(student).patch(arg1);
	}

	@When("^user triggers the Patch request$")
	public void user_triggers_the_Patch_request() throws Throwable {
		System.out.println("response: " + response.prettyPrint());

	}

	@When("^user provides id \"([^\"]*)\" and triggers Delete request$")
	public void user_provides_id_and_triggers_Delete_request(String arg1)
			throws Throwable {
		response = request.when().delete(arg1);
	}

	@Then("^user record is deleted successfully with the status code as \"([^\"]*)\"$")
	public void user_record_is_deleted_successfully_with_the_status_code_as(
			String arg1) throws Throwable {
		System.out.println("response: " + response.prettyPrint());
		json = response.then().statusCode(Integer.valueOf(arg1));
	}

}
