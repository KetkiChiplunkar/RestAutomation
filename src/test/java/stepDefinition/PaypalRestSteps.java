package stepDefinition;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import Paypal.Amount;
import Paypal.CreatePaymentPojo;
import Paypal.Details;
import Paypal.Item_List;
import Paypal.Items;
import Paypal.Payer;
import Paypal.Payment_Options;
import Paypal.Shipping_address;
import Paypal.Transactions;
import Paypal.redirect_urls;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class PaypalRestSteps {

	private static String username = "Af0NMC4Q2LpwMJrYlaiRo2hOg5ZSXuaNjXohH-CRdRX9_K69R9DQB5itY4VoeT82H9R5RK0w_Z8vuLVk";
	private static String password = "EPrZAg8BjH8NocBLad2HuU2AAKteyL1dUE8dB3m9WluYtWmaRk-jBrX0BDQ3DsJgzI05cpwjBk0FR1RA";
	Response response;
	public static String accessToken;
	private ValidatableResponse json;
	RequestSpecification request;
	private static String payment_id;
	CreatePaymentPojo pojo = new CreatePaymentPojo();

	redirect_urls red_urls = new redirect_urls();

	/**
	 * First remove all the white space from JSON and then go to code beautify
	 * escape and unescape https://codebeautify.org/java-escape-unescape
	 */
	private static String body = "{ \"intent\": \"sale\", \"payer\": { \"payment_method\": \"paypal\" }, \"transactions\": [ { \"amount\": { \"total\": \"30.11\", \"currency\": \"USD\", \"details\": { \"subtotal\": \"30.00\", \"tax\": \"0.07\", \"shipping\": \"0.03\", \"handling_fee\": \"1.00\", \"shipping_discount\": \"-1.00\", \"insurance\": \"0.01\" } }, \"description\": \"The payment transaction description.\", \"custom\": \"EBAY_EMS_90048630024435\", \"invoice_number\": \"48787589673\", \"payment_options\": { \"allowed_payment_method\": \"INSTANT_FUNDING_SOURCE\" }, \"soft_descriptor\": \"ECHI5786786\", \"item_list\": { \"items\": [ { \"name\": \"hat\", \"description\": \"Brown hat.\", \"quantity\": \"5\", \"price\": \"3\", \"tax\": \"0.01\", \"sku\": \"1\", \"currency\": \"USD\" }, { \"name\": \"handbag\", \"description\": \"Black handbag.\", \"quantity\": \"1\", \"price\": \"15\", \"tax\": \"0.02\", \"sku\": \"product34\", \"currency\": \"USD\" } ], \"shipping_address\": { \"recipient_name\": \"Brian Robinson\", \"line1\": \"4th Floor\", \"line2\": \"Unit #34\", \"city\": \"San Jose\", \"country_code\": \"US\", \"postal_code\": \"95131\", \"phone\": \"011862212345678\", \"state\": \"CA\" } } } ], \"note_to_payer\": \"Contact us for any questions on your order.\", \"redirect_urls\": { \"return_url\": \"https://example.com/return\", \"cancel_url\": \"https://example.com/cancel\" } }";

	@Given("^user provide rest uri$")
	public void user_provide_rest_uri() throws Throwable {
		RestAssured.baseURI = "https://api.sandbox.paypal.com/v1";
		RestAssured.basePath = "/oauth2";
	}

	@Given("^the user enter key as \"([^\"]*)\" and value as \"([^\"]*)\"$")
	public void the_user_enter_key_as_and_value_as(String arg1, String arg2)
			throws Throwable {
		request = given().parameters(arg1, arg2).auth().preemptive()
				.basic(username, password);
	}

	@When("^user sends the Post request$")
	public void user_sends_the_Post_request() throws Throwable {
		response = request.when().post("/token");
	}

	@Then("^the user gets the access token in the response$")
	public void the_user_gets_the_access_token_in_the_response()
			throws Throwable {
		System.out.println("---response----");
		accessToken = response.then().log().all().extract()
				.path("access_token");
		System.out.println("__________________________Response for the Access Token__________________");
		System.out.println("__________________________________________________________________________");
		response.then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
		System.out.println("Access token is: " + accessToken);
	}

	@Given("^user provides rest uri for create payment$")
	public void user_provides_rest_uri_for_create_payment() throws Throwable {
		RestAssured.baseURI = "https://api.sandbox.paypal.com";
		RestAssured.basePath = "/v1";
	//request = given().contentType(ContentType.JSON).log().body();
	//request = given().contentType(ContentType.JSON).log().ifValidationFails();

	}

	@Given("^user provides the \"([^\"]*)\" as \"([^\"]*)\" and its \"([^\"]*)\"$")
	public void user_provides_the_as_and_its(String arg1, String arg2,
			String arg3) throws Throwable {
		
		request = given().contentType(ContentType.JSON).auth()
				.oauth2(accessToken).log().body();

	}

	@When("^the user provides the message body for create payment$")
	public void the_user_provides_the_message_body_for_create_payment()
			throws Throwable {
 
		response = request.when().body(body).post("/payments/payment");
	}

	@Then("^the user is successfully able to create payment$")
	public void the_user_is_successfully_able_to_create_payment()
			throws Throwable {
		
		payment_id = response.then().log().all().extract()
				.path("id");
		System.out.println("Payment Id is: " + payment_id);

	
	}

	@When("^the user provides the intent as \"([^\"]*)\"$")
	public void the_user_provides_the_intent_as(String arg1) throws Throwable {

		pojo.setIntent(arg1);
	}

	@When("^the user provides payer information$")
	public void the_user_provides_payer_information() throws Throwable {
		Payer payer = new Payer();
		payer.setPayment_method("paypal");
		pojo.setPayer(payer);
	}

	@When("^the user provides transactions information$")
	public void the_user_provides_transactions_information() throws Throwable {
		Transactions transactions = new Transactions();
		// Amount
		Amount amount = new Amount();
		amount.setTotal("30.11");
		amount.setCurrency("USD");
		// Details
		Details details = new Details();
		details.setSubtotal("30.00");
		details.setTax("0.07");
		details.setShipping("0.03");
		details.setHandling_fee("1.00");
		details.setShipping_discount("-1.00");
		details.setInsurance("0.01");
		amount.setDetails(details);
		// ItemList
		Item_List item_list = new Item_List();
		Shipping_address ship = new Shipping_address();
		ship.setRecipient_name("Ketki");
		ship.setLine1("4th lane");
		ship.setLine2("Unit #34");
		ship.setCity("San Jose");
		ship.setCountry_code("US");
		ship.setPostal_code("95131");
		ship.setPhone("123456789");
		ship.setState("CA");
		
		Items item1 = new Items();
		item1.setName("handbag");
		//item1.setDescription(description)("Item description");
		item1.setDescription("Black handbag");
		item1.setQuantity("1");
		item1.setPrice("15");
		item1.setTax("0.02");
		item1.setSku("product34");
		item1.setCurrency("USD");
		Items item2 = new Items();
		item2.setName("hat");
		//item2.setDescriptor("Item description2");
		item2.setDescription("Brown hat");
		item2.setQuantity("5");
		item2.setPrice("3");
		item2.setTax("0.01");
		item2.setSku("1");
		item2.setCurrency("USD");
		List<Items> itms = new ArrayList<Items>();
		itms.add(item1);
		itms.add(item2);
		item_list.setItems(itms);
		item_list.setShipping_address(ship);
		// Payment options
		Payment_Options payment_options = new Payment_Options();
		payment_options.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");

		List<Transactions> trans = new ArrayList<Transactions>();
		transactions.setAmount(amount);
		transactions.setItem_list(item_list);
		transactions.setCustom("EBAY_EMS_90048630024435");
		transactions.setDescription("The payment transaction description.");
		transactions.setInvoice_number("48787589673");
		transactions.setPayment_options(payment_options);
		transactions.setSoft_descriptor("ECHI5786786");
		trans.add(transactions);
		pojo.setTransactions(trans);
	}

	@When("^the user provides note to payer as \"([^\"]*)\"$")
	public void the_user_provides_note_to_payer_as(String arg1)
			throws Throwable {
		pojo.setNote_to_payer(arg1);
	}

	@When("^the user provides redirect urls as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_provides_redirect_urls_as_and(String arg1, String arg2)
			throws Throwable {
		redirect_urls redirect_urls = new redirect_urls();
		redirect_urls.setReturn_url(arg1);
		redirect_urls.setCancel_url(arg2);
		pojo.setRedirect_urls(redirect_urls);
	}

	@When("^the user provides the request to create payment$")
	public void triggerRequest() {
		
		response = request.when().body(pojo).post("/payments/payment");

	}
	@When("^the user provides Payment id$")
	public void the_user_provides_Payment_id() throws Throwable {
	   response = request.when().get("/payments/payment/"+payment_id);
	}

	@Then("^the user gets the Payment information$")
	public void the_user_gets_the_Payment_information() throws Throwable {
		System.out.println("response: " + response.prettyPrint());
	}








}
