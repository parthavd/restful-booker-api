package testscripts;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.Status_Code;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseLogSpecification;
import pojo.request.createbooking.BookingDates;
import pojo.request.createbooking.CreateBookingRequest;
import pojowithshortcuts.request.createbooking.Bookingdates;

public class CreateBookingTest {
	String token;
	int bookingID;
	pojowithshortcuts.request.createbooking.CreateBookingRequest payload;

	@BeforeMethod
	public void generateToken() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		Response res = RestAssured.given()
				// .log().all() //Prints all the logs and details related to the API call
				// similar to Postman console
				.headers("Content-Type", "application/json")
				.body("{\r\n" + "    \"username\" : \"admin\",\r\n" + "    \"password\" : \"password123\"\r\n" + "}")
				.when().post("/auth").then().assertThat().statusCode(200)
				// .log().all() //This will print the entire Response including Headers, status,
				// time etc.
				.extract().response(); // This will return a Response class object
		token = res.jsonPath().getString("token"); // This will return the String value of element "token" in the
													// response
	}

	@Test(enabled = false)
	public void createBookingTest() {
		Response res = RestAssured.given().headers("Content-Type", "application/json")
				.headers("Accept", "application/json")
				.body("{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				.when().post("/booking");
		Assert.assertEquals(res.getStatusCode(), Status_Code.OK); // Expected status code declared as static variable in
																	// a separate package
		System.out.println(res.getStatusCode()); // Prints very specific status code only E.g. 200
		System.out.println(res.getStatusLine()); // Prints the entire Status code message along with code E.g. HTTP/1.1
													// 200 OK
	}

	@Test(enabled = true)
	public void createBookingTestWithPOJO() {
		payload = new pojowithshortcuts.request.createbooking.CreateBookingRequest();
		Bookingdates bookingDates = new Bookingdates();
		bookingDates.setCheckin("2023-02-23");
		bookingDates.setCheckout("2023-02-27");
		payload.setFirstname("Jason");
		payload.setLastname("Moma");
		payload.setTotalprice(300);
		payload.setDepositpaid(true);
		payload.setAdditionalneeds("breakfast");
		payload.setBookingdates(bookingDates);

		Response res = RestAssured.given().headers("Content-Type", "application/json")
				.headers("Accept", "application/json").body(payload).when().post("/booking");
		Assert.assertEquals(res.getStatusCode(), Status_Code.OK); // Expected status code declared as static variable in
																	// a separate package
		bookingID = res.jsonPath().getInt("bookingid");
		Assert.assertTrue(bookingID > 0);
		validateResponse(res, payload, "booking.");
		System.out.println(bookingID);
	}

	@Test(enabled = false)
	public void createBookingTestWithPOJOPractice() {
		pojowithshortcuts.request.createbooking.CreateBookingRequest bookingRequest = new pojowithshortcuts.request.createbooking.CreateBookingRequest();
		Bookingdates bookingDates = new Bookingdates();
		bookingRequest.setFirstname("Jason");
		bookingRequest.setLastname("Shesr");
		bookingRequest.setAdditionalneeds("Lunch");
		bookingRequest.setDepositpaid(false);
		bookingRequest.setTotalprice(400);
		bookingDates.setCheckin("2023-01-10");
		bookingDates.setCheckout("2023-01-28");
		bookingRequest.setBookingdates(bookingDates);
		Response res = RestAssured.given().headers("Content-Type", "application/json")
				.headers("Accept", "application/json").body(bookingRequest).when().post("/booking");
		Assert.assertEquals(res.statusCode(), Status_Code.OK);
		Assert.assertTrue((res.jsonPath().getInt("bookingid")) > 0);
	}

	@Test(enabled = false)
	public void getBookingIDs() {
		Response res = RestAssured.given().headers("Accept", "application/json").when().get("/booking/");
		// System.out.println("Response from GET is: " + res.asPrettyString());
		Assert.assertEquals(res.getStatusCode(), Status_Code.OK);
		List<Integer> bookingIDObjects = res.jsonPath().getList("bookingid"); // Returns the list of all elements from
																				// the json array with bookingid
																				// elements
		System.out.println(bookingIDObjects.size()); // Returns the total size of the JSON array
		Assert.assertTrue(bookingIDObjects.contains(bookingID)); // Verifies if the booking ID is present in the
																	// response JSON.
	}

	@Test(enabled = false)
	public void getSpecificBookingID() {
		Response res = RestAssured.given().headers("Accept", "application/json").when().get("/booking/" + bookingID);
		System.out.println("Response from GET is: " + res.asPrettyString());
		Assert.assertEquals(res.getStatusCode(), Status_Code.OK);
		validateResponse(res, payload, "");
	}

	// Reusable method to validate the values of the booking details in response.
	// Can be used for both CREATE and GET calls as same details are in the response
	// schema
	private void validateResponse(Response res, pojowithshortcuts.request.createbooking.CreateBookingRequest payload,
			String object) {
		Assert.assertEquals(res.jsonPath().getString(object + "firstname"), payload.getFirstname());
		Assert.assertEquals(res.jsonPath().getString(object + "lastname"), payload.getLastname());
		Assert.assertEquals(res.jsonPath().getInt(object + "totalprice"), payload.getTotalprice());
		Assert.assertEquals(res.jsonPath().getString(object + "additionalneeds"), payload.getAdditionalneeds());
		Assert.assertEquals(res.jsonPath().getBoolean(object + "depositpaid"), payload.isDepositpaid());
		Assert.assertEquals(res.jsonPath().getString(object + "bookingdates.checkin"),
				payload.getBookingdates().getCheckin());
		Assert.assertEquals(res.jsonPath().getString(object + "bookingdates.checkout"),
				payload.getBookingdates().getCheckout());
	}
	
	@Test(enabled = false)
	public void getSpecificBookingIDDeserialized() {
		//int bookingID = 3453;
		Response res = RestAssured.given().headers("Accept", "application/json").when().get("/booking/" + bookingID);
		System.out.println("Response from GET is: " + res.asPrettyString());
		Assert.assertEquals(res.getStatusCode(), Status_Code.OK);
		pojowithshortcuts.request.createbooking.CreateBookingRequest resBody = res.as(pojowithshortcuts.request.createbooking.CreateBookingRequest.class);
		System.out.println("Deserialized response body: " + resBody);
		Assert.assertEquals(resBody.firstname, payload.firstname);
		Assert.assertEquals(resBody.lastname, payload.lastname);
		Assert.assertTrue(resBody.equals(payload));
	}
	
	@Test(enabled = true)
	public void updateBookingIDTest() {
		//int bookingID = 3453;
		payload.firstname = "Kirsten";
		Response res = RestAssured.given().
				headers("Accept", "application/json")
				.headers("Content-Type", "application/json")
				.headers("Cookie", "token=" + token)
				.body(payload)
				.when()
				.put("/booking/" + bookingID);
		System.out.println("Response from PUT is: " + res.asPrettyString());
		Assert.assertEquals(res.getStatusCode(), Status_Code.OK);
		pojowithshortcuts.request.createbooking.CreateBookingRequest resBody = res.as(pojowithshortcuts.request.createbooking.CreateBookingRequest.class);
		System.out.println("Deserialized response body: " + resBody);
		Assert.assertTrue(resBody.equals(payload));
	}
	
	
}
