package stepDefinition;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import RestClasses.Jira;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JiraAPISteps {

	// RestAssured request;
	Response response;
	RequestSpecification request;
	static String name;
	static String value;
	static String body = "{\"update\":{\"worklog\":[{\"add\":{\"timeSpent\":\"60m\",\"started\":\"2011-07-05T11:05:00.000+0000\"}}]},\"fields\":{\"project\":{\"id\":\"JIR\"},\"summary\":\"something'swrong\",\"issuetype\":{\"id\":\"10000\"},\"assignee\":{\"name\":\"homer\"},\"reporter\":{\"name\":\"smithers\"},\"priority\":{\"id\":\"20000\"},\"labels\":[\"bugfix\",\"blitz_test\"],\"timetracking\":{\"originalEstimate\":\"10\",\"remainingEstimate\":\"5\"},\"security\":{\"id\":\"10000\"},\"versions\":[{\"id\":\"10000\"}],\"environment\":\"environment\",\"description\":\"description\",\"duedate\":\"2011-03-11\",\"fixVersions\":[{\"id\":\"10001\"}],\"components\":[{\"id\":\"10000\"}],\"customfield_30000\":[\"10000\",\"10002\"],\"customfield_80000\":{\"value\":\"red\"},\"customfield_20000\":\"06/Jul/113:25PM\",\"customfield_40000\":\"thisisatextfield\",\"customfield_70000\":[\"jira-administrators\",\"jira-software-users\"],\"customfield_60000\":\"jira-software-users\",\"customfield_50000\":\"thisisatextarea.bigtext.\",\"customfield_10000\":\"09/Jun/81\"}}";

	@Given("^user enters its username and password$")
	public void user_enters_its_username() throws Throwable {
		RestAssured.baseURI = "http://localhost:8088/";
		RestAssured.basePath = "/rest";

		request = given().contentType(ContentType.JSON).log().all();

	}

	@When("^the user triggers post request$")
	public void theuser_triggers_post_request() throws Throwable {
		Jira jira = new Jira();
		jira.setUsername("chiplunkar.k1");
		jira.setPassword("ket190785");
		response = request.when().body(jira).post("/auth/1/session");
	}

	@Then("^the user gets the session id$")
	public void the_user_gets_the_session_id() throws Throwable {
		
        Map<String, String> sessionValue = response.jsonPath().getMap("session");
        name = sessionValue.get("name");
        value = sessionValue.get("value");
        System.out.println(sessionValue.get("name"));
        System.out.println(sessionValue.get("value"));
		
	}

	
	@Given("^user enters the URI and path value$")
	public void user_enters_the_URI_and_path_value() throws Throwable {
		RestAssured.baseURI = "http://localhost:8088/";
		RestAssured.basePath = "/rest";
		request = given().header("Content-Type", "application/json").header("Cookie", name+"="+value);
	}

	@When("^user provides cookies for the session and enter issue related information$")
	public void user_provides_cookies_for_the_session_and_enter_issue_related_information() throws Throwable {
	    response=request.when().body("{"+
	    	    "\"fields\": {"+
	    	       "\"project\":{"+
	    	          "\"key\": \"JIR\""+
	    	       "},"+
	    	       "\"summary\": \"Issue 5 for adding comment\","+
	    	       "\"description\": \"Creating my second bug\","+
	    	       "\"issuetype\": {"+
	    	          "\"name\": \"Bug\""+
	    	       "}"+
	    	   "}}").post("/api/2/issue");
	}

	@Then("^the user is successfully able to create issue$")
	public void the_user_is_successfully_able_to_create_issue() throws Throwable {
	    response.then().log().all();
	}
}
