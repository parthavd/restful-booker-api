package testscripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Status_Code;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.datafaker.Faker;
import pojowithshortcuts.request.createbooking.Bookingdates;

public class CreateBookingJsonObjectTest {
	
	@Test(enabled = true)
	public void createBookingTestWithJsonObject() {
		
		Faker faker = new Faker();
		
		JSONObject jsonBookingDate = new JSONObject();
		jsonBookingDate.put("checkin", "2023-05-02");
		jsonBookingDate.put("checkout", "2023-05-03");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstname", faker.name().firstName());
		jsonObject.put("lastname", faker.name().lastName());
		jsonObject.put("totalprice", faker.number().positive()); //Returns a random positive number
		jsonObject.put("depositpaid", faker.bool().bool()); //Returns random bool values
		jsonObject.put("additionalneeds", "Breakfast");
		jsonObject.put("bookingdates", jsonBookingDate);
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		Response res = RestAssured.given().headers("Content-Type", "application/json")
				.headers("Accept", "application/json")
				.body(jsonObject)
				.log().all()
				.when().post("/booking");
		Assert.assertEquals(res.getStatusCode(), Status_Code.OK); // Expected status code declared as static variable in
																	// a separate package
		System.out.println(res.getStatusCode()); // Prints very specific status code only E.g. 200
		System.out.println(res.getStatusLine()); // Prints the entire Status code message along with code E.g. HTTP/1.1
		
		
		
	
	}

	

}
