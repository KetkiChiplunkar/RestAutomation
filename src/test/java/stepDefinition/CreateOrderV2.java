package stepDefinition;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateOrderV2 {

	Response response;
	RequestSpecification request;
	private static String accessToken;
	private static String orderId;
	private String username = "AZSPs87ht5A-R9aHbJ0bDR0SLgEDlKydUE1_XqKntgKP0vx34yrDXgidHBimX7oIfzKyzxic0g3gS0tm";

	private String password = "EHWJ8cQbYAzGTUAO9RbbEKj7ZTvP4TLDvucZq_ZwMySVUTJBNbn_LESjFATzki6uOZz8FXzLlQHAc6U_";

	private String body = "{\"intent\":\"CAPTURE\",\"purchase_units\":[{\"amount\":{\"currency_code\":\"USD\",\"value\":\"100.00\"}}]}";

	private String body1 = "[ { \"op\": \"add\", \"path\": \"/purchase_units/@reference_id=='default'/invoice_id\", \"value\": \"INV-HighFashions\" } ]";

	@Given("^User gets the acess token$")
	public void getUserToken() throws Throwable {
		RestAssured.baseURI = "https://api.sandbox.paypal.com/v1";
		RestAssured.basePath = "oauth2";
		accessToken = given().parameter("grant_type", "client_credentials")
				.auth().preemptive().basic(username, password).when()
				.post("/token").then().log().all().extract()
				.path("access_token");
		System.out.println("Access Token is " + accessToken);
	}

	@Given("^user gives the URI and enters the access token$")
	public void user_gives_the_URI_and_enters_the_access_token()
			throws Throwable {
		RestAssured.baseURI = "https://api.sandbox.paypal.com/v2";
		RestAssured.basePath = "/checkout/";
		request = given().contentType(ContentType.JSON).auth()
				.oauth2(accessToken).log().all();
	}

	@When("^user triggers the Post request to create order$")
	public void user_triggers_the_post_reques_to_create_order()
			throws Throwable {
		response = request.when().body(body).post("orders");
		// request.when().body(body).post("orders");

	}

	@When("^user triggers the Get requests to get order$")
	public void user_triggers_the_Get_requests_to_get_order() throws Throwable {
		System.out.println("Order Id is " + orderId);
		response = request.when().get("orders/" + orderId);
		// response = request.when().get("/payments/payment/"+payment_id);
	}

	@Then("^user is successfully get the order details$")
	public void user_is_successfully_get_the_order_details() throws Throwable {
		System.out.println("Order Id is:  "
				+ response.then().log().all().extract());
		System.out.println("=================Assertion for Content Type and Status Code=============");
		response.then().log().all().assertThat().contentType(ContentType.JSON).and().statusCode(200);

	}

	@Then("^user is successfully able to create order$")
	public void user_is_successfully_able_to_create_order() throws Throwable {
		System.out.println("---response----");
		// json = response.then().statusCode(201);
		// response.then().log().headers();

		System.out.println("Order Id is:  "
				+ response.then().log().all().extract().path("id"));
		;
		orderId = response.then().log().all().statusCode(201).extract().path("id");
	

		String rel = response.then().log().all().extract().path("links[0].rel");
		// Traversing the JSON Path from the response
		System.out
				.println("++++++++++++++++++++this is links rel++++++++++++++"
						+ rel);
		// System.out.println("response: " + response.prettyPrint());
		// int statusCode = response.getStatusCode();
		System.out.println("Status Code is " + response.getStatusCode());
		// System.out.println("Response is as "+response.getBody().asString());
	}

	@When("^user triggers the Patch request to update the order$")
	public void user_triggers_the_Patch_request_to_update_the_order()
			throws Throwable {
		response = request.when().body(body1).patch("orders/" + orderId);
	}

	@Then("^user is successfully able to patch order$")
	public void user_is_successfully_able_to_patch_order() throws Throwable {

		response.then().assertThat().statusCode(204);
	}

}
